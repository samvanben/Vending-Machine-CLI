package com.techelevator.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GumTest {

    @Test
    void getSound() {
        String button = "A1";
        String name = "U-Chews";
        double price = 1.65;
        int stock = 5;
        Gum gum = new Gum(button, name, price, stock);

        String sound = gum.getSound();

        String expected = "Chew Chew, Yum!";
        String actual = gum.getSound();
        assertEquals(expected, sound);
    }
@Test
    void testForItemInheritance() {
    String button = "A1";
    String name = "U-Chews";
    double price = 1.65;
    int stock = 5;
    Gum gum = new Gum(button, name, price, stock);

        String expectedName = "U-Chews";
        String actualName = gum.getName();
        assertEquals(expectedName, actualName);

        double expectedPrice = 1.65;
        double actualPrice = gum.getPrice();
        assertEquals(expectedPrice, actualPrice);

        int expectedStock = 5;
        int actualStock = gum.getStock();
        assertEquals(expectedStock, actualStock);

    String expectedButton = "A1";
    String actualButton = gum.getButton();
    assertEquals(expectedButton, actualButton);
    }
}