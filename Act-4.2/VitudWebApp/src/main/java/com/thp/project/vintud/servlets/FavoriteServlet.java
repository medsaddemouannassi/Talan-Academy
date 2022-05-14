package com.thp.project.vintud.servlets;

import com.thp.project.vintud.dao.controller.FavoriteController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FavoriteServlet", value = "/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            FavoriteController favoriteController = new FavoriteController();
            request.setAttribute("myFavorites", favoriteController.getFavorite(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/favorite.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FavoriteController favoriteController = new FavoriteController();
        favoriteController.deleteFromFavorite(Integer.parseInt(request.getParameter("myFavoriteId")), (Integer) request.getSession().getAttribute("id"));
        try {
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            request.setAttribute("myFavorites", favoriteController.getFavorite(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/favorite.jsp").forward(request, response);
    }
}
