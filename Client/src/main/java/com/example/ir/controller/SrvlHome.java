package com.example.ir.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SrvlHome", value = "/home")
public class SrvlHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageR", "/home.jsp");
        RequestDispatcher dsp = req.getRequestDispatcher("/index.jsp");
        dsp.forward(req, resp);
    }
}