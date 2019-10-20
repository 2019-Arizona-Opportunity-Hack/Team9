package com.cusd80.c3.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.FamilyApi;
import com.cusd80.c3.api.model.Caregiver;
import com.cusd80.c3.api.model.Caregiver.ChildCareTypeEnum;
import com.cusd80.c3.api.model.Dependent;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.repo.MemberRepository;

@RestController
public class FamilyController implements FamilyApi {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseEntity<Family> familyCaregiverIdGet(String caregiverId) {
        return ResponseEntity.ok(mapFamily(memberRepository.findById(caregiverId).orElseThrow()));
    }

    private Family mapFamily(MemberEntity member) {
        Caregiver caregiver = new Caregiver();
        caregiver.setCaregiverId(member.getId());
        caregiver.setChildCareType(ChildCareTypeEnum.fromValue(member.getChildCareType()));

        List<Dependent> dependents = new ArrayList<>();

        Family family = new Family();
        family.setCaregiver(caregiver);
        family.setDependents(dependents);
        return family;
    }

}
