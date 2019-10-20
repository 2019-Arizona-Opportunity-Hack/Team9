package com.cusd80.c3.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cusd80.c3.server.util.UUIDEntity;

import lombok.Data;

@Data
@Table(name = "check_in")
@Entity(name = "CheckIn")
public class CheckInEntity implements UUIDEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = STRATEGY)
    @Column(name = "check_in_id", nullable = false, length = 36)
    private String id;

    @Column(name = "check_in_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "member_id", nullable = false, length = 36)
    private String memberId;

    @Column(name = "service_id", nullable = false, length = 36)
    private String serviceId;

}
