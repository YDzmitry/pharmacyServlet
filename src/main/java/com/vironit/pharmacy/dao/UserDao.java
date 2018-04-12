package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.User;
import java.util.List;

public interface UserDao extends Dao<User,Integer> {

    @Override
    User create(User user) throws CustomGenericException;

    @Override
    List<User> getAll() throws CustomGenericException;

    @Override
    User getByPK(Integer key) throws CustomGenericException;

    @Override
    void update(User user);

    @Override
    void delete(User user);
}
