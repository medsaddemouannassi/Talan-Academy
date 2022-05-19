package com.thp.project.vintud.servlets;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.controller.AnnouncementController;
import com.thp.project.vintud.dao.controller.FavoriteController;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AnnouncementsServlet", value = "/AnnouncementsServlet")
public class AnnouncementsServlet extends HttpServlet {
    private List<AnnouncementImpl> announcements;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
            AnnouncementController announcementController = applicationContext.getBean("announcementController", AnnouncementController.class);
            FavoriteController favoriteController = applicationContext.getBean("favoriteController", FavoriteController.class);
            if (request.getSession().getAttribute("id") != null) {
                announcements = announcementController.getAnnouncements();
//                announcements.removeIf(elem -> (int) request.getSession().getAttribute("id") == elem.getUserId());
                request.setAttribute("announcements", announcements);
                request.setAttribute("favorites", favoriteController.getFavorite((int) request.getSession().getAttribute("id")));
            } else {
                request.setAttribute("announcements", announcementController.getAnnouncements());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
        AnnouncementController announcementController = applicationContext.getBean("announcementController", AnnouncementController.class);
        FavoriteController favoriteController = applicationContext.getBean("favoriteController", FavoriteController.class);
        if (request.getParameter("action").equals("favorite")) {
            favoriteController.addToFavorite(Integer.parseInt(request.getParameter("announcementId")), (Integer) request.getSession().getAttribute("id"));
        } else {
            favoriteController.deleteFromFavorite(Integer.parseInt(request.getParameter("announcementId")), (Integer) request.getSession().getAttribute("id"));
        }
        announcements = announcementController.getAnnouncements();
//        announcements.removeIf(elem -> (int) request.getSession().getAttribute("id") == elem.getUserId());
        request.setAttribute("announcements", announcements);
        request.setAttribute("favorites", favoriteController.getFavorite((int) request.getSession().getAttribute("id")));
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcements.jsp").forward(request, response);
    }
}
