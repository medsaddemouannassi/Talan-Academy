package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.MyAnnouncementsController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MyAnnouncementsServlet", value = "/MyAnnouncementsServlet")
public class MyAnnouncementsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : 2;
            MyAnnouncementsController myAnnouncementsController = new MyAnnouncementsController();
            request.setAttribute("myAnnouncements", myAnnouncementsController.getMyAnnouncements(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/myannouncements.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
