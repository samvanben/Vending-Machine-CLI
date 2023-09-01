package com.techelevator.Controller;

import com.techelevator.Model.Munchy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryControllerTest {

    @Test
    void loadInventory() {

    }

    // Can't test for feed money because it's a user input

    @Test
    void selectButton() {
        String button = "A4";
        String name = "Chippos";
        double price = 3.85;
        int stock = 5;
        Munchy munchy = new Munchy(button, name, price, stock);

        String expectedButton = "A4";
        String actualButton = munchy.getButton();
        assertEquals(expectedButton, actualButton);
    }

    @Test
    void getChange() {

    }

    @Test
    void logTransactions() {
    }
}