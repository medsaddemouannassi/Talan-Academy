package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.AnnouncementController;
import com.thp.project.vintud.dao.controller.SignInController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        SignInController signInController = new SignInController();
        if (!signInController.logIn(email, password).equals("Please verify your email/password")) {
            AnnouncementController announcementController = new AnnouncementController();
            request.setAttribute("announcements", announcementController.getAnnouncements());
            this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
        } else {
            request.setAttribute("messageLogin", signInController.logIn(email, password));
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
