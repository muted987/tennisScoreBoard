package com.muted987.tennisScoreBoard.listener;

import com.muted987.tennisScoreBoard.dao.matchDao.MatchDaoImpl;
import com.muted987.tennisScoreBoard.dao.playerDao.PlayerDaoImpl;
import com.muted987.tennisScoreBoard.service.FinishedMatchesPersistenceService;
import com.muted987.tennisScoreBoard.service.MatchScoreCalculationService;
import com.muted987.tennisScoreBoard.service.NewMatchService;
import com.muted987.tennisScoreBoard.service.OngoingMatchService;
import com.muted987.tennisScoreBoard.utils.HibernateSessionFactory;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;

@WebListener
public class AppContextListener implements ServletContextListener {

    private final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
    private final OngoingMatchService ongoingMatchService = new OngoingMatchService();
    private final MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();
    private final PlayerDaoImpl playerDao = new PlayerDaoImpl(this.sessionFactory);
    private final MatchDaoImpl matchDao = new MatchDaoImpl(this.sessionFactory);
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService(this.matchDao);
    private final NewMatchService newMatchService = new NewMatchService(this.ongoingMatchService, this.playerDao);


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("ongoingMatchService", this.ongoingMatchService);
        servletContext.setAttribute("matchScoreCalculationService", this.matchScoreCalculationService);
        servletContext.setAttribute("finishedMatchService", this.finishedMatchesPersistenceService);
        servletContext.setAttribute("matchDao", this.matchDao);
        servletContext.setAttribute("playerDao", this.playerDao);
        servletContext.setAttribute("newMatchService", this.newMatchService);
    }
}
