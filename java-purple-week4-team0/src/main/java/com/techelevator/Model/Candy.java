package com.techelevator.Model;

public class Candy extends Item{
    public Candy(String button, String name, double price, int stock) {
        super(button, name, price, stock);
    }

    @Override
    public String getSound() {
        return "Yummy Yummy, So Sweet!";
    }
}
