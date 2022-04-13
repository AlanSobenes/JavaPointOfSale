package com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas;

import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.ComboTopping;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.Topping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Pizza extends Item {
    private String name;
    private String size;
    private double price;
    private List<Topping> toppings = new ArrayList<Topping>();
    private List<ComboTopping> comboToppings = new ArrayList<ComboTopping>();
    DecimalFormat df = new DecimalFormat("0.00");

    public Pizza(String name, String size, double price) {
        super("Pizza");
        this.name = name;
        this.size = size;
        this.price = price;
        if (this.size == "Medium") {
            this.price += 5.00;
        }
        if (this.size == "Large") {
            this.price += 10.00;
        }
        if (this.size == "Extra Large") {
            this.price += 15.00;
        }

    }


    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        double total = 0;
        if (!toppings.isEmpty()) {
            for (Topping topping : toppings) {
                total += 2.50;
            }
        }

        return this.price + total;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public List<Topping> getToppings() {
        return toppings;
    }

    public List<ComboTopping> getComboToppings() {
        return comboToppings;
    }
    public void addComboToppings(ComboTopping comboTopping) {

        comboToppings.add(comboTopping);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}