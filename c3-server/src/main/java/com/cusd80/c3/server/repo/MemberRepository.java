package com.cusd80.c3.server.repo;

import com.cusd80.c3.server.enums.MemberType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.MemberEntity;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends CrudRepository<MemberEntity, String> {
    List<MemberEntity> findByParentId(String parentId);

    //null handling in JPA sucks
    List<MemberEntity> findByPhoneNumberAndType(String phoneNumber, MemberType type);
    List<MemberEntity> findByLastNameAndType(String lastName, MemberType type);
    List<MemberEntity> findByBirthDateAndType(LocalDate birthDate, MemberType type);

}
