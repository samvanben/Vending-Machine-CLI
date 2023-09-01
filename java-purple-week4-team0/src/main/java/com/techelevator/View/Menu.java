package com.techelevator.View;

import com.techelevator.Model.Item;

import java.awt.*;
import java.util.Scanner;

public class Menu {

    // Options for main menu
    public void chooseVendingOption(String[] options){

        System.out.println("Welcome to our menu");
        for(String option : options){
            System.out.println(option);

        }
    }

    // Options for "(2) Purchase"
    public void purchaseOptions(String options){

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");

        }
    /*This might be a method for selecting a button, which then corresponds to item in the list*/


        }



