package org.example.dao;

import org.example.model.SaleItem;
import java.sql.Connection;
import java.util.List;

public class SaleItemDAO extends GenericDaoImpl<SaleItem> implements GenericDAO<SaleItem>{

    public SaleItemDAO(Connection connection) {
        super(SaleItem::new, connection);
        super.tableName = "sale_item";
        super.columns = List.of("quantity", "percentual_discount");
    }
}
