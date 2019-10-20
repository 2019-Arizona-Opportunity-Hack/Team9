package com.cusd80.c3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.server.entity.ServiceEntity;
import com.cusd80.c3.server.repo.ServiceRepository;

@RestController
@RequestMapping("services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepRegistry;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ServiceEntity> list() {
        return serviceRepRegistry.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ServiceEntity get(@PathVariable("id") String id) {
        return serviceRepRegistry.findById(id).orElse(null);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ServiceEntity put(@PathVariable(name = "id", required = false) String id, @RequestBody ServiceEntity service) {
        if (id != null && !id.isBlank()) {
            service.setId(id);
        }
        return serviceRepRegistry.save(service);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public boolean put(@PathVariable(name = "id", required = true) String id) {
        if (serviceRepRegistry.existsById(id)) {
            serviceRepRegistry.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
