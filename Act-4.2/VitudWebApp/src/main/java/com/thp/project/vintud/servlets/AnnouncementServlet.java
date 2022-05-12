package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.CreateAnnouncementController;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
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
        AnnouncementImpl announcement = new AnnouncementImpl();
        announcement.setTitle(request.getParameter("title"));
        announcement.setDescription(request.getParameter("description"));
        String category = !request.getParameter("category").equals(null) ? request.getParameter("category").trim(): null;
        announcement.setCategoryId(Integer.parseInt(category));
        String price = !request.getParameter("price").equals(null) ? request.getParameter("price").trim(): null;
        announcement.setPrice(Integer.parseInt(price));
        announcement.setLocalisation(request.getParameter("localisation"));
        announcement.setUserId((Integer) request.getSession().getAttribute("id"));

        CreateAnnouncementController createAnnouncementController = new CreateAnnouncementController();
        request.setAttribute("createAnnouncementMsg", createAnnouncementController.createAnnouncement(announcement));
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcement.jsp").forward(request, response);
    }
}
