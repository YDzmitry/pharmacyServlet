package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoManagerImpl extends UserDaoImpl {
    public UserDaoManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    /*ublic UserDaoManagerImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return super.getSelectQuery();
    }

    @Override
    public String getCreateQuery() {
        return super.getCreateQuery();
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
