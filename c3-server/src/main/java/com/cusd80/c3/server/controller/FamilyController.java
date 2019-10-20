package com.cusd80.c3.server.controller;

import com.cusd80.c3.api.FamilyApi;
import com.cusd80.c3.api.model.Caregiver;
import com.cusd80.c3.api.model.Family;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController implements FamilyApi {

    @Override
    public ResponseEntity<Family> familyCaregiverIdGet(String caregiverId) {
        Family family = new Family();
        Caregiver giver = new Caregiver();
        giver.setCaregiverId("123");
        family.setCaregiver(giver);
        return ResponseEntity.ok(family);
    }
}