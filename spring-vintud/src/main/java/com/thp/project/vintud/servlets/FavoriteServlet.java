package com.thp.project.vintud.servlets;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.controller.FavoriteController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "FavoriteServlet", value = "/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
            FavoriteController favoriteController = applicationContext.getBean("favoriteController", FavoriteController.class);
            request.setAttribute("myFavorites", favoriteController.getFavorite(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/favorite.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
            FavoriteController favoriteController = applicationContext.getBean("favoriteController", FavoriteController.class);
            favoriteController.deleteFromFavorite(Integer.parseInt(request.getParameter("myFavoriteId")), (Integer) request.getSession().getAttribute("id"));
            HttpSession session = request.getSession();
            int id = session.getAttribute("id") != null ? (int) session.getAttribute("id") : null;
            request.setAttribute("myFavorites", favoriteController.getFavorite(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/favorite.jsp").forward(request, response);
    }
}
