package com.techelevator.Model;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {
@Test
    public void testGetSound(){
        String button = "A3";
        String name = "Snykkers";
        double price = 4.25;
        int stock = 5;
        Candy candy = new Candy(button, name, price, stock);

        String sound = candy.getSound();

        String expected = "Yummy Yummy, So Sweet!";
        String actual = candy.getSound();
        assertEquals(expected, sound);
    }
    @Test
    void testForItemInheritance() {
        String button = "A3";
        String name = "Snykkers";
        double price = 4.25;
        int stock = 5;
        Candy candy = new Candy(button, name, price, stock);

        String expectedName = "Snykkers";
        String actualName = candy.getName();
        assertEquals(expectedName, actualName);

        double expectedPrice = 4.25;
        double actualPrice = candy.getPrice();
        assertEquals(expectedPrice, actualPrice);

        int expectedStock = 5;
        int actualStock = candy.getStock();
        assertEquals(expectedStock, actualStock);

        String expectedButton = "A3";
        String actualButton = candy.getButton();
        assertEquals(expectedButton, actualButton);
    }
}