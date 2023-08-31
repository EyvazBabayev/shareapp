package com.shareapp.controller;

import com.shareapp.dao.UserDaoImpl;
import com.shareapp.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private UserDaoImpl userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        register(request,response);
    }
    private void register(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String name =request.getParameter("name");
        String surname =request.getParameter("surname");
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        User user=new User();
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setPassword(password);


        try {
            userDao.register(user);
            request.getSession().setAttribute("name",name);
            request.getSession().setAttribute("username",username);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        response.sendRedirect("user/share");

    }
}
