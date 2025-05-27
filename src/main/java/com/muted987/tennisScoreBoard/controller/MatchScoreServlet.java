package com.muted987.tennisScoreBoard.controller;

import com.muted987.tennisScoreBoard.dto.MatchDto;
import com.muted987.tennisScoreBoard.service.FinishedMatchesPersistenceService;
import com.muted987.tennisScoreBoard.service.MatchScoreCalculationService;
import com.muted987.tennisScoreBoard.service.OngoingMatchService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {

    private OngoingMatchService ongoingMatchService;
    private MatchScoreCalculationService matchScoreCalculationService;
    private FinishedMatchesPersistenceService finishedMatchesPersistenceService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.ongoingMatchService = (OngoingMatchService) servletContext.getAttribute("ongoingMatchService");
        this.matchScoreCalculationService = (MatchScoreCalculationService) servletContext.getAttribute("matchScoreCalculationService");
        this.finishedMatchesPersistenceService = (FinishedMatchesPersistenceService) servletContext.getAttribute("finishedMatchService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        MatchDto match = ongoingMatchService.get(uuid).orElseThrow(() -> new RuntimeException("MatchNotFound"));
        req.setAttribute("match", match);
        req.setAttribute("player1", match.getPlayer1());
        req.setAttribute("player2", match.getPlayer2());
        req.setAttribute("uuid", uuid);
        req.getRequestDispatcher("match-score.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        int playerScoredCode = Integer.parseInt(req.getParameter("scoredPlayerCode"));
        MatchDto match = ongoingMatchService.get(uuid).orElseThrow(() -> new RuntimeException("MatchNotFound"));
        if (match.getWinner() == null) {
            matchScoreCalculationService.calculateScore(match, playerScoredCode);
        } else {
            finishedMatchesPersistenceService.saveMatch(match);
            ongoingMatchService.remove(uuid);
            resp.sendRedirect(req.getContextPath() + "/matches");
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/match-score?uuid=" + uuid);
    }
}
