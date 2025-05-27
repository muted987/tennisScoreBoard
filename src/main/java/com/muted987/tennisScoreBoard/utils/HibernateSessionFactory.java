package com.muted987.tennisScoreBoard.utils;

import com.muted987.tennisScoreBoard.entity.Match;
import com.muted987.tennisScoreBoard.entity.Player;
import com.muted987.tennisScoreBoard.exceptions.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory(){};

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Player.class);
                configuration.addAnnotatedClass(Match.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (RuntimeException e) {
                throw new HibernateException(ExceptionMessageUtil.HIBERNATE_EXCEPTION_MESSAGE);
            }
        }
        return sessionFactory;
    }


}
