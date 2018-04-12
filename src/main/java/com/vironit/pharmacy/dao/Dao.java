package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Dao<T extends Identified<PK>, PK extends Serializable> {
    T create(T t) throws IOException;
    List<T> getAll() throws IOException;
    T getByPK(Integer key) throws CustomGenericException;
    void update(T t);
    void delete(T t);
}
