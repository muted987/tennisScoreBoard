package com.muted987.tennisScoreBoard.controller;

import com.muted987.tennisScoreBoard.entity.Match;
import com.muted987.tennisScoreBoard.service.FinishedMatchesPersistenceService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesServlet extends HttpServlet {

     private FinishedMatchesPersistenceService finishedMatchesPersistenceService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.finishedMatchesPersistenceService = (FinishedMatchesPersistenceService) servletContext.getAttribute("finishedMatchService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Match> matches = finishedMatchesPersistenceService.getAllMatches();
        req.setAttribute("matches", matches);
        req.getRequestDispatcher("matches.jsp").forward(req, resp);
    }
}
