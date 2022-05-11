package com.octest.servlets;

import com.octest.bdd.Noms;
import com.octest.beans.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Noms tableNoms = new Noms();
        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setPrenom(request.getParameter("prenom"));

        Noms tableNoms = new Noms();
        tableNoms.ajouterUtilisateur(utilisateur);

        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
}
