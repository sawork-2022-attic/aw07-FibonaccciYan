package com.example.webpos.db;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.sql.*;

@Repository
public class MySQL implements PosDB {

    private List<Product> products = null;
    private Cart cart;

    @Override
    public List<Product> getProducts() {
        try {
            if (products == null)
                products = parseMySQL();
        } catch (Exception e) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        return this.cart;
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product product : getProducts()) {
            if (product.getId().equals(productId))
                return product;
        }
        return null;
    }

    private List<Product> parseMySQL() throws Exception {

        List<Product> showList = new ArrayList<>();
        Random random = new Random();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "root", "ysy79891332");
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM products WHERE imageURLHighRes != '' LIMIT 50;";
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            String main_cat = resultSet.getString("main_cat");
            String title = resultSet.getString("title");
            String asin = resultSet.getString("asin");
            String category = resultSet.getString("category");
            List<String> categories = new ArrayList<String>(Arrays.asList(category.split(",")));
            String imageURLHighRes = resultSet.getString("imageURLHighRes");
            List<String> images = new ArrayList<String>(Arrays.asList(imageURLHighRes.split(",")));
            showList.add(new Product(asin, title, random.nextInt(300), images.get(random.nextInt(images.size())), main_cat, categories, images));
        }
        resultSet.close();
        stmt.close();
        connection.close();
        return showList;
    }
}