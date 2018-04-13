package com.vironit.pharmacy.servlet;

import com.vironit.pharmacy.dao.HibernateUtil;
import com.vironit.pharmacy.dao.UserDaoImpl;
import com.vironit.pharmacy.model.Role;
import com.vironit.pharmacy.model.TypeAccount;
import com.vironit.pharmacy.model.User;
import com.vironit.pharmacy.validator.CreatingNewUserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("error.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String login = (String) req.getAttribute("login");
        String login = "login3456";
        try {
            UserDaoImpl userDao = new UserDaoImpl(HibernateUtil.getSessionFactory());
            userDao.getByLogin(login);
            resp.sendRedirect("/successCreateUser.jsp");
        }catch (Exception e){
            CreatingNewUserValidator creatingNewUserValidator = new CreatingNewUserValidator();
            creatingNewUserValidator.validate(e);
            req.setAttribute("errMessageMap",creatingNewUserValidator.getErrMessageMap());
            req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }
}
