package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.MyAnnouncementsController;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MyAnnouncementsServlet", value = "/MyAnnouncementsServlet")
public class MyAnnouncementsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            MyAnnouncementsController myAnnouncementsController = new MyAnnouncementsController();
            request.setAttribute("myAnnouncements", myAnnouncementsController.getMyAnnouncements(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/myannouncements.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("edit").equals("edit")) {
            String myAnnouncementId = request.getParameter("myAnnouncementId");
            this.getServletContext().getRequestDispatcher("/WEB-INF/update-announcement.jsp").forward(request, response);
        } else if (request.getParameter("delete").equals("delete")) {
            MyAnnouncementsController myAnnouncementsController = new MyAnnouncementsController();
            AnnouncementImpl announcement = new AnnouncementImpl();
            String id = request.getParameter("id") != null ? request.getParameter("id").trim() : null;
            String userId = request.getParameter("userId") != null ? request.getParameter("userId").trim() : null;
            announcement.setId(Integer.parseInt(id));
            announcement.setUserId(Integer.parseInt(userId));
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
}
