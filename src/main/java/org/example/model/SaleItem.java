package org.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleItem implements Entity {
    private int id;
    private Product product;
    private int quantity;
    private double percentualDiscount;

    public SaleItem(int id, Product product, int quantity, double percentualDiscount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.percentualDiscount = percentualDiscount;
    }

    public SaleItem(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.quantity = rs.getInt("quantity");
        this.percentualDiscount = rs.getDouble("percentual_discount");
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPercentualDiscount() {
        return percentualDiscount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPercentualDiscount(double percentualDiscount) {
        this.percentualDiscount = percentualDiscount;
    }

    public SaleItem() {
    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new SaleItem(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement pstmt) throws SQLException {
        pstmt.setInt(1, getQuantity());
        pstmt.setDouble(2, getPercentualDiscount());
        return pstmt;
    }
}