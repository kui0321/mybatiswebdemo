package com.wsk.web.servlet;

import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import com.wsk.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usersServlet.do")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if ("addUsers".equals(flag)){
            this.addUsers(req, resp);
        }
    }

    //处理添加用户请求
    private void addUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = this.createUsers(req);
        UsersService usersService = new UsersServiceImpl();
        System.out.println(usersService);
        usersService.addUsers(users);
        resp.sendRedirect("ok.jsp");
    }

    //获取提交数据
    private Users createUsers(HttpServletRequest req){
        String username = req.getParameter("username");
        String usersex = req.getParameter("usersex");
        Users users = new Users();
        users.setUsername(username);
        users.setUsersex(usersex);
        System.out.println(users);
        return users;
    }
}
