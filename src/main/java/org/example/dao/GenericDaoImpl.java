package org.example.dao;

import org.example.model.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class GenericDaoImpl<T extends Entity> implements GenericDAO<T> {

    Connection connection;
    String tableName;
    List<String> columns;
    private Supplier<T> supplier;

    public GenericDaoImpl(Supplier<T> supplier, Connection connection) {
        this.supplier = supplier;
        this.connection = connection;
    }

    @Override
    public List<T> getAll() {
        List<T> returningList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            while (rs.next()) {
                T productType = (T) supplier.get().constructFromResultSet(rs);
                returningList.add(productType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returningList;
    }

    @Override
    public T getById(int id) {
        T returningObject = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                returningObject = (T) supplier.get().constructFromResultSet(rs);
            }

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
        return returningObject;
    }

    @Override
    public void deleteById(int id) {

        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upsert(T object) {
        try {
            PreparedStatement pstmt;
            if (object.getId() == 0) {
                pstmt = connection.prepareStatement("INSERT INTO "
                        + tableName
                        + " ("
                        + columns.stream().collect(Collectors.joining(", "))
                        + ") VALUES ("
                        + columns.stream().map(item -> "?").collect(Collectors.joining(", "))
                        +")");
                pstmt = object.prepareStatement(pstmt);
            } else {
                pstmt = connection.prepareStatement("UPDATE "
                        + tableName
                        + " SET "
                        + columns.stream().map(item -> item + " = ?").collect(Collectors.joining(", "))
                        + "WHERE id = ?");
                pstmt = object.prepareStatement(pstmt);
                pstmt.setInt(columns.size() + 1, object.getId());
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
