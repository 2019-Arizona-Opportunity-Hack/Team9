package com.cusd80.c3.server.repo;

import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.MemberEntity;

public interface MemberRepository extends CrudRepository<MemberEntity, String> {

}
