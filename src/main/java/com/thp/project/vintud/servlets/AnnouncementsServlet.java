package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.AnnouncementController;
import com.thp.project.vintud.dao.controller.FavoriteController;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AnnouncementsServlet", value = "/AnnouncementsServlet")
public class AnnouncementsServlet extends HttpServlet {
    private List<AnnouncementImpl> announcements;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnouncementController announcementController = new AnnouncementController();
        FavoriteController favoriteController = new FavoriteController();
        if (request.getSession().getAttribute("id") != null) {
            announcements = announcementController.getAnnouncements();
            announcements.removeIf(elem -> (int) request.getSession().getAttribute("id") == elem.getUserId());
            request.setAttribute("announcements", announcements);
            request.setAttribute("favorites", favoriteController.getFavorite((int) request.getSession().getAttribute("id")));
        } else {
            request.setAttribute("announcements", announcementController.getAnnouncements());
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FavoriteController favoriteController = new FavoriteController();
        if (request.getParameter("action").equals("favorite")) {
            favoriteController.addToFavorite(Integer.parseInt(request.getParameter("announcementId")), (Integer) request.getSession().getAttribute("id"));
        } else {
            favoriteController.deleteFromFavorite(Integer.parseInt(request.getParameter("announcementId")), (Integer) request.getSession().getAttribute("id"));
        }
        AnnouncementController announcementController = new AnnouncementController();
        announcements = announcementController.getAnnouncements();
        announcements.removeIf(elem -> (int) request.getSession().getAttribute("id") == elem.getUserId());
        request.setAttribute("announcements", announcements);
        request.setAttribute("favorites", favoriteController.getFavorite((int) request.getSession().getAttribute("id")));
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
    }
}
