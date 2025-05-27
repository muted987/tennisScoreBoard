package com.muted987.tennisScoreBoard.controller;

import com.muted987.tennisScoreBoard.service.NewMatchService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private NewMatchService newMatchService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.newMatchService = (NewMatchService) servletContext.getAttribute("newMatchService");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init newMatchServlet");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player1Name = req.getParameter("player1");
        String player2Name = req.getParameter("player2");
        UUID newMatchUUID = newMatchService.createMatch(player1Name, player2Name);
        resp.sendRedirect(req.getContextPath() + "/match-score?uuid=" + newMatchUUID.toString());
    }
}
