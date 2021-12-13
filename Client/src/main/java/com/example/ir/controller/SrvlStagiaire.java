package com.example.ir.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SrvlStagiaire", value = "/stagiaire")
public class SrvlStagiaire extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("pageR", "/stagiaire.jsp");
            RequestDispatcher dsp = req.getRequestDispatcher("/index.jsp");
            dsp.forward(req, resp);

    }
}
