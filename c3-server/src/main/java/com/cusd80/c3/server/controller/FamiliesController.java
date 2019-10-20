package com.cusd80.c3.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.FamiliesApi;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.enums.MemberType;
import com.cusd80.c3.server.repo.MemberRepository;
import com.cusd80.c3.server.util.DateUtil;
import com.cusd80.c3.server.util.FamilyMapper;

@CrossOrigin
@RestController
public class FamiliesController implements FamiliesApi {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseEntity<List<Family>> familiesGet(
        @RequestParam(value = "last_name", required = false) final String lastName,
        @RequestParam(value = "date_of_birth", required = false) final String dateOfBirth,
        @RequestParam(value = "phone_number", required = false) final String phoneNumber
    )
    {

        List<Family> families = new ArrayList<>();
        List<MemberEntity> memberEntities = new ArrayList<>();

        //add the parent to the family
        if (StringUtils.isNotBlank(phoneNumber)) {
            memberEntities = memberRepository.findByPhoneNumber(phoneNumber);
        } else if (StringUtils.isNotBlank(lastName)) {
            memberEntities = memberRepository.findByLastNameContainingIgnoreCase(lastName);
        } else if (StringUtils.isNotBlank(dateOfBirth)) {
            memberEntities = memberRepository.findByBirthDate(DateUtil.parseDate(dateOfBirth));
        }

        //nested loops are not great but...i'm tired.
        //ideally, the dependents woudl be defined in the entity.
        for (MemberEntity entity : memberEntities) {
            if (entity == null || entity.getType() != MemberType.PRIMARY) {
                entity = memberRepository.findById(entity.getParentId()).orElse(null);
            }
            if (entity == null || entity.getType() != MemberType.PRIMARY) {
                continue;
            }

            Family family = FamilyMapper.fromCaregiverMember(entity);

            //find the dependents
            List<MemberEntity> dependents = memberRepository.findByParentId(family.getCaregiver().getCaregiverId());

            //map the dependents to the appropriate data type
            family.setDependents(FamilyMapper.fromDependentMember(dependents));
            families.add(family);
        }

        return ResponseEntity.ok(families);
    }

}
