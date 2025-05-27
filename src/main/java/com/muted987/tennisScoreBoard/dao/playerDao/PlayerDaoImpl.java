package com.muted987.tennisScoreBoard.dao.playerDao;

import com.muted987.tennisScoreBoard.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class PlayerDaoImpl implements PlayerDao {

    private final Session session;

    public PlayerDaoImpl(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public void save(String name) {
        Transaction transaction = session.beginTransaction();
        session.persist(Player.builder().name(name).build());
        transaction.commit();
    }

    @Override
    public Optional<Player> findByName(String name) {
        String query = "FROM Player p where p.name = :name";
        return session.createQuery(query, Player.class).setParameter("name", name).uniqueResultOptional();
    }
}
