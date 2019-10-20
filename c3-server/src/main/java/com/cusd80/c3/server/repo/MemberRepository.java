package com.cusd80.c3.server.repo;

import org.springframework.data.repository.CrudRepository;

import com.cusd80.c3.server.entity.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
