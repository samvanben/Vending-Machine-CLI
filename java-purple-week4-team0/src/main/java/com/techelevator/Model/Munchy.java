package com.techelevator.Model;

public class Munchy extends Item {
    public Munchy(String button, String name, double price, int stock) {
        super(button, name, price, stock);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }

}
