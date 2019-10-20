package com.cusd80.c3.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cusd80.c3.api.CheckInApi;
import com.cusd80.c3.api.model.CheckIn;
import com.cusd80.c3.server.mapper.CheckInMapper;
import com.cusd80.c3.server.repo.CheckInRepository;

@CrossOrigin
@RestController
@Transactional
public class CheckInController implements CheckInApi {

    @Autowired
    private CheckInRepository checkInRegistry;

    @Autowired
    private CheckInMapper checkInMapper;

    @Override
    public ResponseEntity<Void> checkInPost(@Valid List<CheckIn> checkIn) {
        checkInRegistry.saveAll(checkIn.stream().map(checkInMapper::toEntity).collect(Collectors.toList()));
        return ResponseEntity.ok().build();
    }

}
