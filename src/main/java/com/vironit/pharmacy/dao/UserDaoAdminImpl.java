package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoAdminImpl extends UserDaoImpl {
    public UserDaoAdminImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
/*
    public UserDaoAdminImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return super.getSelectQuery() +
                "FROM pharmacy.users inner join pharmacy.typeaccount on " +
                "users.typeaccount_id = typeaccount.id inner join pharmacy.roles on roles_id = roles.id";
    }

    @Override
    public String getCreateQuery() {
         return "insert into pharmacy.users (login, password, typeaccount_id, roles_id) \n" +
                "values (?,?,?,?); ";
    }

    @Override
    public String getUpdateQuery() {
        return super.getUpdateQuery();
    }

    @Override
    public String getDeleteQuery() {
        return super.getDeleteQuery();
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws CustomGenericException {
        return super.parseResultSet(rs);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws CustomGenericException {
        super.prepareStatementForInsert(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws CustomGenericException {
        super.prepareStatementForUpdate(statement, object);
    }*/
}
