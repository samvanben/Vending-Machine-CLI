package com.techelevator.Model;

public class Gum extends Item{
    public Gum (String button, String name, double price, int stock) {
        super(button, name, price, stock);
    }

    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
