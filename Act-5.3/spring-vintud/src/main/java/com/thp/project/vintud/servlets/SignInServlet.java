package com.thp.project.vintud.servlets;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.controller.SignInController;
import com.thp.project.vintud.entity.Role;
import com.thp.project.vintud.entity.User;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
            UserImpl user = (UserImpl) applicationContext.getBean(User.class);
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setPseudo(request.getParameter("pseudo"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setPhoneNumber(request.getParameter("phone"));
            user.setAddress(request.getParameter("address"));
            String role = !request.getParameter("role").equals(null) ? request.getParameter("role").trim() : null;
            RoleImpl roleImpl = (RoleImpl) applicationContext.getBean(Role.class);
            try{
                roleImpl.setRole_id(Integer.parseInt(role));
            } catch(NumberFormatException ex){ // handle your exception
                ex.printStackTrace();
            }
            user.setRole_id(roleImpl);

            SignInController signInController = applicationContext.getBean(SignInController.class);

            request.setAttribute("message", signInController.signUp(user));
            if (signInController.signUp(user).equals("Welcome")) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
