package com.cusd80.c3.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cusd80.c3.server.util.UUIDEntity;

import lombok.Data;

@Data
@Table(name = "service")
@Entity(name = "Service")
public class ServiceEntity implements UUIDEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = STRATEGY)
    @Column(name = "service_id", nullable = false, length = 36)
    private String id;

    @Column(name = "service_name", nullable = true, length = 255)
    private String name;

    @Column(name = "sort_order", nullable = false)
    private int sortOrder;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

}
