package com.techelevator.Model;

import java.math.BigDecimal;

public abstract class Item {

    private String button;
    private String name;
    private double price;
    private String type;
    private int stock = 5;



//To create an item, it must have these four properties
    public Item(String button, String name, double price, int stock) {
        this.button = button;
        this.name = name;
        this.price = price;
        this.stock = stock;

    }

    public String getButton() {
        return button;
    }


    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return button + " " + name + " " + price + " Quantity Remaining: " + stock;
    }

    public abstract String getSound();
}
