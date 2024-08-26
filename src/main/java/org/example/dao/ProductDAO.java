package org.example.dao;

import org.example.model.Product;
import java.sql.Connection;
import java.util.List;

public class ProductDAO extends GenericDaoImpl<Product> implements GenericDAO<Product> {
    public ProductDAO(Connection connection) {
        super(Product::new, connection);
        super.tableName = "product";
        super.columns = List.of("product_type_id", "description", "value");
    }
}
