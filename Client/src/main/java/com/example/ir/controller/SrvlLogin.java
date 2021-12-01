package com.example.ir.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SrvlLogin", value = "/login")
public class SrvlLogin extends HttpServlet {

    String erreur;

    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String demande;
        String vueReponse = "";
        erreur = null;

        try {
            demande = getDemande(req);
            if (demande.equalsIgnoreCase("login.log")) {
                vueReponse = login(req);
            } else if (demande.equalsIgnoreCase("connecter.log")) {
                vueReponse = connecter(req);
            } else if (demande.equalsIgnoreCase("deconnecter.log")) {
                vueReponse = deconnecter(req);
            } else {
                vueReponse = login(req);
            }
        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            req.setAttribute("erreurR", erreur);
            req.setAttribute("pageR", vueReponse);
            RequestDispatcher dsp = req.getRequestDispatcher("/index.jsp");
            if (vueReponse.contains(".log")) {
                dsp = req.getRequestDispatcher(vueReponse);
            }
            dsp.forward(req, resp);
        }
    }

    private String login(HttpServletRequest request) {
        return "login.jsp";
    }

    private String connecter(HttpServletRequest request) {
        return "home.jsp";
    }

    private String deconnecter(HttpServletRequest request) {
        return "home.jsp";
    }
}
