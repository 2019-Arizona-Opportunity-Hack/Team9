package com.cusd80.c3.server.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.FamilyApi;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.repo.MemberRepository;
import com.cusd80.c3.server.util.FamilyMapper;

@CrossOrigin
@RestController
public class FamilyController implements FamilyApi {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseEntity<Family> familyCaregiverIdGet(String caregiverId) {
        Family daFamily;

        //add the parent to the family
        daFamily = FamilyMapper.fromCaregiverMember(memberRepository.findById(caregiverId).orElseThrow());

        //find the dependents
        List<MemberEntity> dependents = memberRepository.findByParentId(daFamily.getCaregiver().getCaregiverId());

        //map the dependents to the appropriate data type
        daFamily.setDependents(FamilyMapper.fromDependentMember(dependents));

        return ResponseEntity.ok(daFamily);
    }

    @Override
    public ResponseEntity<Void> familyPost(@Valid Family family) {
        return persistRecord(family);
    }

    @Override
    public ResponseEntity<Void> familyCaregiverIdPut(String caregiverId, @Valid Family family) {
        family.getCaregiver().setCaregiverId(caregiverId);
        return persistRecord(family);
    }

    private ResponseEntity<Void> persistRecord(Family family) {
        MemberEntity memberParent;

        //get the parent and write it to the DB
        memberParent = FamilyMapper.toParentEntity(family);

        //todo: does this return new uuid?
        memberParent = memberRepository.save(memberParent);

        //set the parent id so the subsequent dependent calls hve the parent
        family.getCaregiver().setCaregiverId(memberParent.getId());

        //map the child entities
        List<MemberEntity> dependents = FamilyMapper.toDependentEntities(family);

        //write the children to the db
        for (MemberEntity memberEntity : dependents) {
            memberRepository.save(memberEntity);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
