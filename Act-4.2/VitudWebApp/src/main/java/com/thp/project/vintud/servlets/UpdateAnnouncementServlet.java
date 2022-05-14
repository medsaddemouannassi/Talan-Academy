package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.MyAnnouncementsController;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateAnnouncementServlet", value = "/UpdateAnnouncementServlet")
public class UpdateAnnouncementServlet extends HttpServlet {
    private String myAnnouncementId;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        myAnnouncementId = request.getParameter("myAnnouncementId");
        request.setAttribute("myAnnouncementId", request.getParameter("myAnnouncementId"));
        request.setAttribute("myAnnouncementTitle", request.getParameter("myAnnouncementTitle"));
        request.setAttribute("myAnnouncementDescription", request.getParameter("myAnnouncementDescription"));
        request.setAttribute("myAnnouncementPrice", request.getParameter("myAnnouncementPrice"));
        request.setAttribute("myAnnouncementCategory", (int) Double.parseDouble(request.getParameter("myAnnouncementCategory")));
        request.setAttribute("myAnnouncementLocalisation", request.getParameter("myAnnouncementLocalisation"));
        this.getServletContext().getRequestDispatcher("/WEB-INF/update-announcement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnouncementImpl announcement = new AnnouncementImpl();
        String id = myAnnouncementId != null ? myAnnouncementId.trim(): null;
        assert id != null;
        announcement.setId(Integer.parseInt(id));
        announcement.setTitle(request.getParameter("title"));
        announcement.setDescription(request.getParameter("description"));
        String category = request.getParameter("category") != null ? request.getParameter("category").trim(): null;
        assert category != null;
        announcement.setCategoryId(Integer.parseInt(category));
        String price = request.getParameter("price") != null ? request.getParameter("price").trim(): null;
        assert price != null;
        announcement.setPrice(Integer.parseInt(price));
        announcement.setLocalisation(request.getParameter("localisation"));
        announcement.setUserId((int) request.getSession().getAttribute("id"));

        MyAnnouncementsController updateAnnouncementController = new MyAnnouncementsController();
        request.setAttribute("updateAnnouncementMsg", updateAnnouncementController.updateAnnouncement(announcement));
        this.getServletContext().getRequestDispatcher("/WEB-INF/announcement.jsp").forward(request, response);
    }
}
