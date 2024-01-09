package com.laba.solvd.delivery.persistence.impl.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class PersistenceConfig {
    private static final SqlSessionFactory sessionFactory;


    static {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
            sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);

        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static SqlSession openSession() {
        return sessionFactory.openSession(true);
    }
}
