package com.cusd80.c3.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.ServicesApi;
import com.cusd80.c3.api.model.Service;
import com.cusd80.c3.server.mapper.ServiceMapper;
import com.cusd80.c3.server.repo.ServiceRepository;

@CrossOrigin
@RestController
@Transactional
public class ServicesController implements ServicesApi {

    @Autowired
    private ServiceRepository serviceRegistry;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    @Transactional
    public ResponseEntity<List<Service>> servicesGet() {
        return ResponseEntity.ok(
            serviceRegistry.findByEnabledOrderBySortOrder(true)
                .map(serviceMapper::fromEntity)
                .collect(Collectors.toList())
        );
    }

}
