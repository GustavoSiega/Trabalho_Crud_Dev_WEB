package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.controller.HelloWorldHandler;
import org.example.dao.ProductDAO;
import org.example.dao.ProductTypeDAO;
import org.example.dao.SaleDAO;
import org.example.dao.SaleItemDAO;
import org.example.model.ProductType;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);

            servidor.createContext("/helloWorld", new HelloWorldHandler());

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db", "root", "root"
            );

            ProductTypeDAO productTypeDAO = new ProductTypeDAO(connection);
            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(0, "Teste"));
            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(4, "Teste 2"));
            productTypeDAO.getAll().forEach(System.out::println);
            System.out.println(productTypeDAO.getById(1));
            productTypeDAO.deleteById(5);
            productTypeDAO.getAll().forEach(System.out::println);

            ProductDAO productDAO = new ProductDAO(connection);
            productDAO.getAll().forEach(System.out::println);

            SaleItemDAO SaleItemDAO = new SaleItemDAO(connection);
            SaleItemDAO.getAll().forEach(System.out::println);

            SaleDAO saleDAO = new SaleDAO(connection);
            saleDAO.getAll().forEach(System.out::println);

            servidor.setExecutor(null);
            servidor.start();
            System.out.println("Servidor rodando na porta 8080");

        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}