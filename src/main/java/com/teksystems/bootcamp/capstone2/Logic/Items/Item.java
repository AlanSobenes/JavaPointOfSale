package com.teksystems.bootcamp.capstone2.Logic.Items;
import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Side;
import com.teksystems.bootcamp.capstone2.Logic.Combos.Combo;


public class Item {
    Pizza pizza;
    Drink drink;
    Side side;
    Combo combo;
    public String type;


    public Item(String type) {
        this.type = type;
    }

    public Item(Pizza pizza){
        this.pizza = pizza;
    };

    public Item(Drink drink) {
        this.drink = drink;
    }

    public Item(Side side) { this.side = side;  }

    public Item(Combo combo) { this.combo = combo; }

    public Pizza getPizza() {
        return pizza;
    }

    public Drink getDrink() {
        return drink;
    }

    public Side getSide() {
        return side;
    }

    public Combo getCombo() {
        return combo;
    }

    public String getType() {
        return type;
    }
}
