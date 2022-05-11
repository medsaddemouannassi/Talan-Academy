package com.thp.project.vintud.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AnnouncementServlet", value = "/AnnouncementServlet")
public class AnnouncementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String localisation = request.getParameter("localisation");


        request.setAttribute("title", title);
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcement.jsp").forward(request, response);
    }
}
