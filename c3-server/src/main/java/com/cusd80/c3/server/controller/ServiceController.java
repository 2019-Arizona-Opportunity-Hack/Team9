package com.cusd80.c3.server.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.ServiceApi;
import com.cusd80.c3.api.model.Service;
import com.cusd80.c3.server.entity.ServiceEntity;
import com.cusd80.c3.server.mapper.ServiceMapper;
import com.cusd80.c3.server.repo.ServiceRepository;

@CrossOrigin
@RestController
@Transactional
@RequestMapping("services")
public class ServiceController implements ServiceApi {

    @Autowired
    private ServiceRepository serviceRegistry;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public ResponseEntity<Void> servicePost(@Valid Service service) {
        serviceRegistry.save(serviceMapper.toEntity(service));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> serviceServiceIdDelete(String serviceId) {
        ServiceEntity service = serviceRegistry.findById(serviceId).orElseThrow();
        service.setEnabled(false);
        serviceRegistry.save(service);
        return ResponseEntity.ok().build();
    }

}
