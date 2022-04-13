package com.teksystems.bootcamp.capstone2.Logic.Items.Drinks;

import com.teksystems.bootcamp.capstone2.Logic.Items.Item;

public class Drink extends Item {
    private String name;
    private double price;


    public Drink(String name, double price) {
        super("Drink");
        this.name = name;
        this.price = price;
    }

    public Drink( String name) {
        super("Drink");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
