package com.thp.project.vintud.servlets;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.controller.CreateAnnouncementController;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "AnnouncementServlet", value = "/AnnouncementServlet")
public class AnnouncementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
        AnnouncementImpl announcement = applicationContext.getBean(AnnouncementImpl.class);
        announcement.setTitle(request.getParameter("title"));
        announcement.setDescription(request.getParameter("description"));
        String category = !request.getParameter("category").equals(null) ? request.getParameter("category").trim(): null;
        announcement.setCategoryId(Integer.parseInt(category));
        String price = !request.getParameter("price").equals(null) ? request.getParameter("price").trim(): null;
        announcement.setPrice(Integer.parseInt(price));
        announcement.setLocalisation(request.getParameter("localisation"));
        announcement.setUserId((Integer) request.getSession().getAttribute("id"));

        CreateAnnouncementController createAnnouncementController = applicationContext.getBean(CreateAnnouncementController.class);
        request.setAttribute("createAnnouncementMsg", createAnnouncementController.createAnnouncement(announcement));
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcement.jsp").forward(request, response);
    }
}
