package com.shareapp.controller;

import com.shareapp.dao.UserDao;
import com.shareapp.dao.UserDaoImpl;
import com.shareapp.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private UserDaoImpl userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkUser(request,response);

    }
    private void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        User user = userDao.getUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("name", user.getName());
            request.getSession().setAttribute("username", user.getUsername());
            response.sendRedirect("user/share");
        } else {
            request.setAttribute("loginError", "Username or Password is incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
