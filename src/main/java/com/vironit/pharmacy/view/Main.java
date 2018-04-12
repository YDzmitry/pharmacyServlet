package com.vironit.pharmacy.view;

import com.vironit.pharmacy.dao.HibernateUtil;
import com.vironit.pharmacy.dao.UserDao;
import com.vironit.pharmacy.dao.UserDaoAdminImpl;
import com.vironit.pharmacy.dao.UserDaoImpl;
import com.vironit.pharmacy.model.Role;
import com.vironit.pharmacy.model.TypeAccount;
import com.vironit.pharmacy.model.User;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {

       /* UserDaoImpl userDao = new UserDaoImpl(HibernateUtil.getSessionFactory());
        //userDao.setSessionFactory(HibernateUtil.getSessionFactory());
        User user = new User();
        Role role = new Role(1,"ADMIN");
        TypeAccount typeAccount = new TypeAccount(1, "ACTIVE");
        user.setLogin("qwe1r88t0yg90123ri12313");
        user.setPassword("123123");
        user.setTypeAccount(typeAccount);
        user.setRole(role);
        userDao.create(user);
/*        User user3 = userDao.getByPK(121);
        System.out.println(user3.toString());*/
        HibernateUtil.shutdown();
        //User user1 = new User();
        //user1 = userDao.getByPK(5);
        //System.out.println(user1.toString());

    }
}
