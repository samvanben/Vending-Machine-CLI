package com.techelevator.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {


    @Test
    void getSound() {
        String button = "A2";
        String name = "Ayle";
        double price = 1.85;
        int stock = 5;
        Drink drink = new Drink(button, name, price, stock);

        String sound = drink.getSound();

        String expected = "Glug Glug, Yum!";
        String actual = drink.getSound();
        assertEquals(expected, sound);


    }
    @Test
    void testForItemInheritance() {
        String button = "A2";
        String name = "Ayle";
        double price = 1.85;
        int stock = 5;
        Drink drink = new Drink(button, name, price, stock);

        String expectedName = "Ayle";
        String actualName = drink.getName();
        assertEquals(expectedName, actualName);

        double expectedPrice = 1.85;
        double actualPrice = drink.getPrice();
        assertEquals(expectedPrice, actualPrice);

        int expectedStock = 5;
        int actualStock = drink.getStock();
        assertEquals(expectedStock, actualStock);

        String expectedButton = "A2";
        String actualButton = drink.getButton();
        assertEquals(expectedButton, actualButton);
    }
}