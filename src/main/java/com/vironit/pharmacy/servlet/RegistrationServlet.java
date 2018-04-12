package com.vironit.pharmacy.servlet;

import com.vironit.pharmacy.dao.HibernateUtil;
import com.vironit.pharmacy.dao.UserDaoImpl;
import com.vironit.pharmacy.model.Customer;
import com.vironit.pharmacy.model.Role;
import com.vironit.pharmacy.model.TypeAccount;
import com.vironit.pharmacy.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet",urlPatterns = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User customer = new User();
        Role role = new Role(3,"CUSTOMER");
        TypeAccount typeAccount = new TypeAccount(1, "VERYFYING");
        customer.setLogin(req.getParameter("login"));
        customer.setPassword(req.getParameter("password"));
        customer.setTypeAccount(typeAccount);
        customer.setRole(role);
        try {
            UserDaoImpl userDao = new UserDaoImpl(HibernateUtil.getSessionFactory());
            userDao.create(customer);
        }catch (Exception e){
            System.out.println("qwe");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
