package com.shareapp.controller;

import com.shareapp.dao.ShareDaoImpl;
import com.shareapp.model.Share;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShareController", value = "/user/share/actions")
public class ShareController extends HttpServlet {
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

        String action=request.getParameter("action");

        if (action ==null){
            request.getRequestDispatcher("/share-form.jsp").forward(request,response);
        }

        switch (action){
            case "new":
                request.getRequestDispatcher("/share-form.jsp").forward(request,response);
                break;
            case "insert":
                insertShare(request,response);
                break;
            case "edit":
                showeditShare(request,response);
            default:
                response.sendRedirect("login.jsp");
        }
    }
    private void insertShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= (String) request.getSession().getAttribute("username");
        String shareName= request.getParameter("shareName");
        String shareArticle=request.getParameter("shareArticle");

        Share share=new Share();
        share.setShareName(shareName);
        share.setShareArticle(shareArticle);
        share.setUsername(username);

        shareDao.insertShare(share);
        response.sendRedirect(request.getContextPath() + "/user/share");

    }
    private void showeditShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
