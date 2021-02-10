package com.tata.storeapp.models;
public class Stock {
    private final double price;
    private final int quantity;

    Stock(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getValue() {
        return getPrice() * getQuantity();
    }
}