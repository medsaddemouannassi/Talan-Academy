package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.AnnouncementController;
import com.thp.project.vintud.entity.Announcement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AnnouncementsServlet", value = "/AnnouncementsServlet")
public class AnnouncementsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnouncementController announcementController = new AnnouncementController();
        request.setAttribute("announcements", announcementController.getAnnouncements());
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
