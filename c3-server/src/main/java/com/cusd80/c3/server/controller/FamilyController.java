package com.cusd80.c3.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.cusd80.c3.server.util.FamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.FamilyApi;
import com.cusd80.c3.api.model.Caregiver;
import com.cusd80.c3.api.model.Caregiver.ChildCareTypeEnum;
import com.cusd80.c3.api.model.Dependent;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.repo.MemberRepository;

import javax.validation.Valid;

@RestController
public class FamilyController implements FamilyApi {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResponseEntity<Family> familyCaregiverIdGet(String caregiverId) {
        return ResponseEntity.ok(mapFamily(memberRepository.findById(caregiverId).orElseThrow()));
    }

    @Override
    public ResponseEntity<Void> familyPost(@Valid Family family) {
        //this try catch is rather lazy but it's a hackathon so...
        try {
            MemberEntity memberParent = new MemberEntity();
            MemberEntity memberChild = new MemberEntity();

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
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
