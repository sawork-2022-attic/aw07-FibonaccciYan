package com.example.webpos.biz;

import com.example.model.Cart;
import com.example.model.Product;

import java.util.List;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    public void checkout(Cart cart);

    public double total(Cart cart);

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);

    public boolean sub(String productId, int amount);

    public boolean delete(String productId);

    public List<Product> products();

    public Product randomProduct();
}
