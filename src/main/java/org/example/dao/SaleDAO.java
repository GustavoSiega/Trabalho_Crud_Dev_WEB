package org.example.dao;

import org.example.model.Sale;
import java.sql.Connection;
import java.util.List;

public class SaleDAO extends GenericDaoImpl<Sale> implements GenericDAO<Sale> {

    public SaleDAO(Connection connection) {
        super(Sale::new, connection);
        super.tableName = "sale";
        super.columns = List.of("insert_at");
    }
}
