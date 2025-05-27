package com.muted987.tennisScoreBoard.dao.matchDao;

import com.muted987.tennisScoreBoard.entity.Match;
import com.muted987.tennisScoreBoard.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MatchDaoImpl implements MatchDao{

    private final Session session;

    public MatchDaoImpl(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public void save(Match match) {
        Transaction transaction = session.beginTransaction();
        session.save(match);
        transaction.commit();
    }

    @Override
    public void get(Long id) {

    }

    @Override
    public List<Match> getAll() {
        String hql = "FROM Match";
        return session.createQuery(hql, Match.class).getResultList();
    }
}
