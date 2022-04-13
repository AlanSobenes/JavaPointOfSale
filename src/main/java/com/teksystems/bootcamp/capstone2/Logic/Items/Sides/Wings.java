package com.teksystems.bootcamp.capstone2.Logic.Items.Sides;

import com.teksystems.bootcamp.capstone2.Logic.Toppings.Flavor;

public class Wings extends Side {

    private String flavorChoice;

    public Wings(String name, double price) {
        super(name, price);
    }

@Override
    public void addFlavorNow(Flavor flavor){

       this.flavorChoice = String.valueOf(flavor);

    }
@Override
    public String getFlavorChoice() {
        return flavorChoice;
    }

}
