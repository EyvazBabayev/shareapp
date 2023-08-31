package com.shareapp.servlets;

import com.shareapp.dao.ShareDaoImpl;
import com.shareapp.model.Share;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShareServlet", value = "/user/share")
public class ShareServlet extends HttpServlet {
    private ShareDaoImpl shareDao;

    @Override
    public void init() {
        shareDao=new ShareDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=(String) request.getSession().getAttribute("username");
        List<Share> shares=shareDao.selectAllShares(username);
        request.setAttribute("shares",shares);
        request.getRequestDispatcher("/share.jsp").forward(request,response );


    }
}