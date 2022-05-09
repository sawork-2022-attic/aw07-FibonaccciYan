package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private Product product;
    private int quantity;

    public void addQuantity(int amount) {
        quantity += amount;
    }

    public boolean subQuantity(int amount) {
        if(quantity > amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return product.toString() +"\t" + quantity;
    }
}
