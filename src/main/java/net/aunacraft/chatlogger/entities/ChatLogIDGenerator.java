package net.aunacraft.chatlogger.entities;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class ChatLogIDGenerator implements IdentifierGenerator {

    public static final String generatorName = "chatlogIDGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    }
}
