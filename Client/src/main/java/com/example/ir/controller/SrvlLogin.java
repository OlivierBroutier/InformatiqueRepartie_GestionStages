package com.example.ir.controller;

import com.example.ir.entity.dto.LoginDTO;
import com.example.ir.entity.dto.UtilisateurDTO;
import com.example.ir.rest.LoginRest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SrvlLogin", value = "/login")
public class SrvlLogin extends HttpServlet {

    private final LoginRest loginRest;

    String erreur;

    public SrvlLogin() {
        this.loginRest = new LoginRest();
    }

    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        if (demande.contains("?")) {
            demande = demande.substring(0, demande.lastIndexOf('?'));
        }
        return demande;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String demande;
        String vueReponse = null;
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
            if (vueReponse != null && vueReponse.contains(".log")) {
                dsp = req.getRequestDispatcher(vueReponse);
            }
            dsp.forward(req, resp);
        }
    }

    private String login(HttpServletRequest request) {
        return "login.jsp";
    }

    private String connecter(HttpServletRequest request) {
        String vueReponse = null;
        LoginDTO loginDTO = new LoginDTO(request.getParameter("login"), request.getParameter("password"), request.getParameter("statut"));
        try {
            UtilisateurDTO utilisateurDTO = this.loginRest.login(loginDTO);
            if(utilisateurDTO.getEtudiant() != null) {
                request.getSession().setAttribute("Prenom", utilisateurDTO.getEtudiant().getPrenomEtudiant());
                request.getSession().setAttribute("Nom", utilisateurDTO.getEtudiant().getNomEtudiant());
                request.getSession().setAttribute("Id", utilisateurDTO.getEtudiant().getId());
                request.getSession().setAttribute("Statut", "E");
            }
            else {
                if (utilisateurDTO.getProfesseur() != null) {
                    request.getSession().setAttribute("Prenom", utilisateurDTO.getProfesseur().getPrenomProf());
                    request.getSession().setAttribute("Nom", utilisateurDTO.getProfesseur().getNomProf());
                    request.getSession().setAttribute("Id", utilisateurDTO.getProfesseur().getId());
                    request.getSession().setAttribute("Statut", "P");
                }
            }
            vueReponse = "home.jsp";
        } catch (Exception e) {
            erreur = e.getMessage();
        }

        return vueReponse;
    }

    private String deconnecter(HttpServletRequest request) {
        request.getSession().removeAttribute("Prenom");
        request.getSession().removeAttribute("Nom");
        request.getSession().removeAttribute("Id");
        request.getSession().removeAttribute("Statut");
        return "home.jsp";
    }
}
