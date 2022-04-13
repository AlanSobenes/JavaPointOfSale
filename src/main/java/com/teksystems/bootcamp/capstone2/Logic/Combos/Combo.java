package com.teksystems.bootcamp.capstone2.Logic.Combos;

import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Side;

public class Combo extends Item {
    Pizza pizza;
    Side side;
    Drink drink;
    private String size;
    private double price;

    public Combo(String size, Pizza pizza, Side side, Drink drink) {
        super("Combo");
        this.size = size;
        this.pizza = pizza;
        this.side = side;
        this.drink = drink;
        if(this.size == "Small"){
            this.price = 20.00;
        }
        if(this.size == "Medium"){
            this.price = 25.00;
        }
        if(this.size == "Large"){
            this.price = 30.00;
        }
        if(this.size == "Extra Large"){
            this.price = 35.00;
        }
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public Side getSide() {
        return side;
    }

    @Override
    public Drink getDrink() {
        return drink;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
