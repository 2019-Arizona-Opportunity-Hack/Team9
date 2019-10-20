package com.cusd80.c3.server.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.MemberEntity;

public interface MemberRepository extends CrudRepository<MemberEntity, String> {

    List<MemberEntity> findByParentId(String parentId);

    List<MemberEntity> findByPhoneNumber(String phoneNumber);

    List<MemberEntity> findByLastNameContainingIgnoreCase(String lastName);

    List<MemberEntity> findByBirthDate(LocalDate birthDate);

}
