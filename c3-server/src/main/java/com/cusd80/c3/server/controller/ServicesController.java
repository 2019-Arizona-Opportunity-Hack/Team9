package com.cusd80.c3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.ServicesApi;
import com.cusd80.c3.server.repo.ServiceRepository;

@RestController
@RequestMapping("services")
public class ServicesController implements ServicesApi {

    @Autowired
    private ServiceRepository serviceRegistry;

    @Override
    public ResponseEntity<Void> servicesGet() {
        // TODO Auto-generated method stub
        return ResponseEntity.ok().build();
    }

}
