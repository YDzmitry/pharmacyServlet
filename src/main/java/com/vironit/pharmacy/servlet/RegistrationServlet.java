package com.vironit.pharmacy.servlet;

import com.vironit.pharmacy.dao.HibernateUtil;
import com.vironit.pharmacy.dao.UserDaoImpl;
import com.vironit.pharmacy.model.Customer;
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
            CreatingNewUserValidator creatingNewUserValidator = new CreatingNewUserValidator();
            creatingNewUserValidator.validate(e);
            req.setAttribute("errMessageMap",creatingNewUserValidator.getErrMessageMap());
            req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopostRega");
    }
}
