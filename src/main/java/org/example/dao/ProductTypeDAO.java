package org.example.dao;

import org.example.model.ProductType;

import java.sql.*;
import java.util.List;

public class ProductTypeDAO extends GenericDaoImpl<ProductType> implements GenericDAO<ProductType> {

    private Connection connection;
    private final String TABLE_NAME = "product_type";

    public ProductTypeDAO(Connection connection) {
        super(ProductType::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = List.of("description");
    }
}