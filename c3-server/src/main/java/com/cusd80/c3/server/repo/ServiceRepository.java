package com.cusd80.c3.server.repo;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.ServiceEntity;

public interface ServiceRepository extends CrudRepository<ServiceEntity, String> {

    Stream<ServiceEntity> findByEnabledOrderBySortOrder(boolean enabled);
    
}
