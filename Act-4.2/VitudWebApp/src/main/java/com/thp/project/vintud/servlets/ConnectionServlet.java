package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.AnnouncementController;
import com.thp.project.vintud.dao.controller.ConnectionController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConnectionServlet", value = "/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ConnectionController signInController = new ConnectionController();
        if (signInController.logIn(email, password) == null) {

            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();

            session.setAttribute("id", (signInController.logIn(email, password)).getId());
            session.setAttribute("firstName", (signInController.logIn(email, password)).getFirstName());
            session.setAttribute("lastName", (signInController.logIn(email, password)).getLastName());

            AnnouncementController announcementController = new AnnouncementController();
            request.setAttribute("announcements", announcementController.getAnnouncements());
            this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
        }
    }
}
