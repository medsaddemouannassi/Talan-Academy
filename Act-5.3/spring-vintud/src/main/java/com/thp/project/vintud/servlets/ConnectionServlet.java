package com.thp.project.vintud.servlets;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.controller.ConnectionController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "ConnectionServlet", value = "/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
        ConnectionController connectionController = applicationContext.getBean("connectionController", ConnectionController.class);
        if (request.getParameter("action").equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (connectionController.logIn(email, password) != null) {
                request.setAttribute("loginMsg", "Welcome");
                HttpSession session = request.getSession();
                session.setAttribute("id", (connectionController.logIn(email, password)).getUser_id());
                session.setAttribute("firstName", (connectionController.logIn(email, password)).getFirstName());
                session.setAttribute("lastName", (connectionController.logIn(email, password)).getLastName());
            } else {
                request.setAttribute("loginMsg", "Please verify your E-mail/Password");
            }
        } else if (request.getParameter("action").equals("logout")) {
            connectionController.logOut((Integer) request.getSession().getAttribute("id"));
            request.getSession().invalidate();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
