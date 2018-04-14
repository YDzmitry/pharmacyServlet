package com.vironit.pharmacy.filter;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.exception.RegistrationValidatorException;
import com.vironit.pharmacy.validator.RegistrationValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter  implements Filter {
    private FilterConfig filterConfig;

    //init method
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    //do filter method
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        RegistrationValidator registrationValidator = new RegistrationValidator();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String passport = req.getParameter("passport");
        try {
            registrationValidator.validate(login, password, passport);
            chain.doFilter(req, resp);
        }catch (RegistrationValidatorException ex){
            req.setAttribute("errMessageMap",ex.getErrMessageMap());
            req.getServletContext().getRequestDispatcher("/loginAndRegistrationPage/registration.jsp").forward(req, resp);
        }
    }

    public void destroy() {
        this.filterConfig = null;
    }
}