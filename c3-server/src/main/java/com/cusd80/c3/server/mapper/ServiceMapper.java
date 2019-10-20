package com.cusd80.c3.server.mapper;

import org.springframework.stereotype.Component;

import com.cusd80.c3.api.model.Service;
import com.cusd80.c3.server.entity.ServiceEntity;

@Component
public class ServiceMapper implements EntityMapper<ServiceEntity, Service> {

    @Override
    public Service fromEntity(ServiceEntity from) {
        Service to = new Service();
        to.setServiceId(from.getId());
        to.setName(from.getName());
        return to;
    }

    @Override
    public ServiceEntity toEntity(Service from) {
        ServiceEntity to = new ServiceEntity();
        to.setId(from.getServiceId());
        to.setName(from.getName());
        return to;
    }

}
