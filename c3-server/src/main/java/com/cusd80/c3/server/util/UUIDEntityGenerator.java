package com.cusd80.c3.server.util;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

public class UUIDEntityGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object instanceof UUIDEntity) {
            String id = ((UUIDEntity) object).getId();
            if (id != null && !id.isBlank()) return id;
        }
        return super.generate(session, object);
    }

}
