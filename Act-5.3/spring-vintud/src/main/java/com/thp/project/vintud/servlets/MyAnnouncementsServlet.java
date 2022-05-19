package com.thp.project.vintud.servlets;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.controller.MyAnnouncementsController;
import com.thp.project.vintud.entity.Announcement;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "MyAnnouncementsServlet", value = "/MyAnnouncementsServlet")
public class MyAnnouncementsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
            MyAnnouncementsController myAnnouncementsController = applicationContext.getBean("myAnnouncementsController", MyAnnouncementsController.class);
            request.setAttribute("myAnnouncements", myAnnouncementsController.getMyAnnouncements(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/myannouncements.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
        MyAnnouncementsController myAnnouncementsController = applicationContext.getBean("myAnnouncementsController", MyAnnouncementsController.class);
        AnnouncementImpl announcement = (AnnouncementImpl) applicationContext.getBean(Announcement.class);
        String id = request.getParameter("id") != null ? request.getParameter("id").trim() : null;
        announcement.setAnnouncement_id(Integer.parseInt(id));
        myAnnouncementsController.deleteAnnouncement(announcement);
        try {
            HttpSession session = request.getSession();
            int idConnectedUser = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            request.setAttribute("myAnnouncements", myAnnouncementsController.getMyAnnouncements(idConnectedUser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/myannouncements.jsp").forward(request, response);
    }
}
