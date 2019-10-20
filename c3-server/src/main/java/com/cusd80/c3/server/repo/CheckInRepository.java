package com.cusd80.c3.server.repo;

import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.CheckInEntity;

public interface CheckInRepository extends CrudRepository<CheckInEntity, String> {

}
