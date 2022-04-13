package com.teksystems.bootcamp.capstone2.Logic.Items.Sides;

import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.Flavor;

public abstract class Side extends Item {
    private String name;
    private double price;
    private String flavorChoice;

    public Side(String name, double price) {
        super("Side");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void addFlavorNow(Flavor flavor);

    public String getFlavorChoice() {
        return null;
    }



    public void setFlavorChoice(String flavorChoice) {
        this.flavorChoice = flavorChoice;
    }
}
