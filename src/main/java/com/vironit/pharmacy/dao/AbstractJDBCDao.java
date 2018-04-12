package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractJDBCDao<T extends Identified<PK>, PK extends Integer> implements Dao<T, PK> {

    private Connection connection;

    /**
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet rs) throws CustomGenericException;

    /**
     * Устанавливает аргументы insert запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws CustomGenericException;

    /**
     * Устанавливает аргументы update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws CustomGenericException;

    @Override
    public T getByPK(Integer key) throws CustomGenericException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new CustomGenericException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public List<T> getAll() throws CustomGenericException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        return list;
    }

    @Override
    public T create(T object) throws CustomGenericException {
        T persistInstance;
        // Добавляем запись
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new CustomGenericException("On create more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        // Получаем только что вставленную запись
        sql = getSelectQuery() + " WHERE pharmacy.users.id = (select MAX(users.id) from pharmacy.users);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new CustomGenericException("Exception on findByPK new create data.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
        return persistInstance;
    }

    @Override
    public void update(T object) throws CustomGenericException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new CustomGenericException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }

    @Override
    public void delete(T object) throws CustomGenericException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new CustomGenericException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new CustomGenericException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new CustomGenericException(e);
        }
    }

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }
}
