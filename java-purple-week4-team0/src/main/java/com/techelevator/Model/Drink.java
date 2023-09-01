package com.techelevator.Model;

public class Drink extends Item{
    public Drink(String button, String name, double price, int stock) {
        super(button, name, price, stock);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
