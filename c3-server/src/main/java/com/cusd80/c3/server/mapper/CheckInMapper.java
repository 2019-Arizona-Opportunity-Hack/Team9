package com.cusd80.c3.server.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.cusd80.c3.api.model.CheckIn;
import com.cusd80.c3.server.entity.CheckInEntity;

@Component
public class CheckInMapper implements EntityMapper<CheckInEntity, CheckIn> {

    @Override
    public CheckIn fromEntity(CheckInEntity from) {
        CheckIn to = new CheckIn();
        to.setCreatedDate(from.getDate().toString());
        to.setMemberId(from.getMemberId());
        to.setServiceId(from.getServiceId());
        return to;
    }

    @Override
    public CheckInEntity toEntity(CheckIn from) {
        CheckInEntity to = new CheckInEntity();
        to.setId(null);
        to.setDate(LocalDateTime.parse(from.getCreatedDate()));
        to.setMemberId(from.getMemberId());
        to.setServiceId(from.getServiceId());
        return to;
    }

}
