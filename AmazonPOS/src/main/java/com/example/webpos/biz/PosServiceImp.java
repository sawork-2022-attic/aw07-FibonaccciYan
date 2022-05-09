package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PosServiceImp implements PosService, Serializable {

    private PosDB posDB;

    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }

    @Override
    public Cart getCart() {

        Cart cart = posDB.getCart();
        if (cart == null){
            cart = this.newCart();
        }
        return cart;
    }

    @Override
    public Cart newCart() {
        return posDB.saveCart(new Cart());
    }

    @Override
    public Product randomProduct() {
        return products().get(ThreadLocalRandom.current().nextInt(0, products().size()));
    }

    @Override
    public void checkout(Cart cart) {

    }

    @Override
    public double total(Cart cart) {
        double sum = 0;
        for(Item item: cart.getItems()) {
            sum += item.getQuantity() * item.getProduct().getPrice();
        }

        return sum;
    }

    @Override
    public boolean add(Product product, int amount) {
        return add(product.getId(), amount);
    }

    @Override
    public boolean add(String productId, int amount) {

        Product product = posDB.getProduct(productId);
        if (product == null) return false;

        if(this.getCart().containItem(new Item(product, amount))) {
            this.getCart().getItem(new Item(product, amount)).addQuantity(amount);
        } else {
            this.getCart().addItem(new Item(product, amount));
        }
        return true;
    }

    @Override
    public boolean sub(String productId, int amount) {
        Product product = posDB.getProduct(productId);
        if (product == null) return false;

        if(this.getCart().removeItem(new Item(product, amount)) == false) {
            this.delete(productId);
        }
        return true;
    }

    @Override
    public boolean delete(String productId) {
        Product product = posDB.getProduct(productId);
        if (product == null) return false;

        this.getCart().deleteItem(new Item(product, -1));
        return true;
    }

    @Override
    public List<Product> products() {
        return posDB.getProducts();
    }
}
