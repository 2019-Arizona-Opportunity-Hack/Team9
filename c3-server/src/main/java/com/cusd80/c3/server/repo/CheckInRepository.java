package com.cusd80.c3.server.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.CheckInEntity;

public interface CheckInRepository extends CrudRepository<CheckInEntity, String> {

    List<CheckInEntity> findByServiceIdAndDateBetweenOrderByDate(
        String serviceId,
        LocalDateTime startDate,
        LocalDateTime endDate
    );

}
