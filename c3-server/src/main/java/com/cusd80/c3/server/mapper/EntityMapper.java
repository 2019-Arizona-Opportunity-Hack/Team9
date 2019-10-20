package com.cusd80.c3.server.mapper;

public interface EntityMapper<E, V> {

    V fromEntity(E from);

    E toEntity(V from);

}
