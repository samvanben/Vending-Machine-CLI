package com.techelevator.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MunchyTest {

    @Test
    void getSound() {
        String button = "A4";
        String name = "Chippos";
        double price = 3.85;
        int stock = 5;
        Munchy munchy = new Munchy(button, name, price, stock);

        String sound = munchy.getSound();

        String expected = "Crunch Crunch, Yum!";
        String actual = munchy.getSound();
        assertEquals(expected, sound);
    }

    // Testing for item class
    @Test
    void testForItemInheritance() {
        String button = "A4";
        String name = "Chippos";
        double price = 3.85;
        int stock = 5;
        Munchy munchy = new Munchy(button, name, price, stock);

        String expectedName = "Chippos";
        String actualName = munchy.getName();
        assertEquals(expectedName, actualName);

        double expectedPrice = 3.85;
        double actualPrice = munchy.getPrice();
        assertEquals(expectedPrice, actualPrice);

        int expectedStock = 5;
        int actualStock = munchy.getStock();
        assertEquals(expectedStock, actualStock);

        String expectedButton = "A4";
        String actualButton = munchy.getButton();
        assertEquals(expectedButton, actualButton);
    }
}