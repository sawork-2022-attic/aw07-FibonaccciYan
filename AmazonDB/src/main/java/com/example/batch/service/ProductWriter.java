package com.example.batch.service;

import com.example.batch.model.Product;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

import java.sql.*;

public class ProductWriter implements ItemWriter<Product>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void write(List<? extends Product> list) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "ysy79891332");
        String sql = "INSERT INTO products (main_cat, title, asin, category, imageURLHighRes)"
                   + "values (?, ?, ?, ?, ?)";
        for(Product product: list) {
            System.out.println(product.toString());
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, product.getMain_cat());
            pstmt.setString(2, product.getTitle());
            pstmt.setString(3, product.getAsin());

            StringBuilder category = new StringBuilder();
            if(!product.getCategory().isEmpty()) {
                for (String str : product.getCategory()) {
                    category.append(str).append(",");
                }
            }
            pstmt.setString(4, category.toString());

            StringBuilder imageURLHighRes = new StringBuilder();
            if(!product.getImageURLHighRes().isEmpty()) {
                for (String str : product.getImageURLHighRes()) {
                    imageURLHighRes.append(str).append(",");
                }
            }
            pstmt.setString(5, imageURLHighRes.toString());

            try{
                pstmt.executeUpdate();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        connection.close();
    }
}
