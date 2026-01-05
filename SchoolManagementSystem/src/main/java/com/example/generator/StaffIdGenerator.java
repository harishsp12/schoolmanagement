package com.example.generator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StaffIdGenerator implements IdentifierGenerator {

    private static final long START_ID = 22501101L;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        Long maxId = (Long) session
                .createQuery("select max(s.id) from Staff s")
                .uniqueResult();

        if (maxId == null) {
            return START_ID;
        }
        return maxId + 1;
    }
}
