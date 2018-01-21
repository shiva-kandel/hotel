package com.example.shiva.foodpay;

import com.example.shiva.foodpay.Product;

public class ShoppingCartEntry2{

    private Product mProduct;
    private int mQuantity;

    public ShoppingCartEntry2(Product product, int quantity) {
        mProduct = product;
        mQuantity = quantity;
    }

    public Product getProduct() {
        return mProduct;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

}
