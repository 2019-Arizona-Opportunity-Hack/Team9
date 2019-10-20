package com.cusd80.c3.server.controller;

import com.cusd80.c3.api.FamiliesApi;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.enums.MemberType;
import com.cusd80.c3.server.repo.MemberRepository;
import com.cusd80.c3.server.util.FamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class FamiliesController implements FamiliesApi {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseEntity<List<Family>> familiesGet(@RequestParam(value = "last_name", required=false) final String lastName, @RequestParam(value = "date_of_birth", required=false) final String dateOfBirth, @RequestParam(value = "phone_number", required=false) final String phoneNumber) {

        List<Family> families = new ArrayList<>();
        List<MemberEntity> memberEntities = new ArrayList<>();

        //add the parent to the family
        if(phoneNumber != null)
        {
            memberEntities = memberRepository.findByPhoneNumberAndType(phoneNumber, MemberType.PRIMARY);
        }
        else if (lastName != null)
        {
            memberEntities = memberRepository.findByLastNameAndType(lastName, MemberType.PRIMARY);
        }
        else if (dateOfBirth != null)
        {
            DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyyMMdd");
            memberEntities = memberRepository.findByBirthDateAndType(LocalDate.parse(dateOfBirth, dTF), MemberType.PRIMARY);
        }


        //nested loops are not great but...i'm tired.
        //ideally, the dependents woudl be defined in the entity.
        for (MemberEntity entity : memberEntities) {

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
