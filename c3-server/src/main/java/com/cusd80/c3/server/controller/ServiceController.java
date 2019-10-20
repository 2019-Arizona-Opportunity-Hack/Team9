package com.cusd80.c3.server.controller;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.ServiceApi;
import com.cusd80.c3.api.model.Service;
import com.cusd80.c3.server.entity.ServiceEntity;
import com.cusd80.c3.server.mapper.ServiceMapper;
import com.cusd80.c3.server.repo.ServiceRepository;

@RestController
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
        if (!serviceRegistry.existsById(serviceId)) throw new NotFoundException();
        serviceRegistry.deleteById(serviceId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ServiceEntity> list() {
        return serviceRegistry.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ServiceEntity get(@PathVariable("id") String id) {
        return serviceRegistry.findById(id).orElse(null);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ServiceEntity put(@PathVariable(name = "id", required = false) String id, @RequestBody ServiceEntity service) {
        if (id != null && !id.isBlank()) {
            service.setId(id);
        }
        return serviceRegistry.save(service);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public boolean put(@PathVariable(name = "id", required = true) String id) {
        if (serviceRegistry.existsById(id)) {
            serviceRegistry.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
