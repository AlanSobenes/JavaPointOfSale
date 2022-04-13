package com.teksystems.bootcamp.capstone2.Logic;

import com.teksystems.bootcamp.capstone2.Logic.Combos.Combo;
import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.CheesyBreadSticks;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.Flavor;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemCreationTest {
    @Test
    public void testShouldReturnASmallPizza(){
        Pizza pizza = new Pizza("Cheese","Small",10.00);
        String actual;
        String expected="Small";
        actual = pizza.getSize();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testShouldReturnACokeDrink(){
        Drink drink = new Drink("Coke",5.00);
        String actual;
        String expected="Coke";
        actual = drink.getName();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testShouldReturnHotWings(){
        Wings wings = new Wings("Hot",10.00);
        wings.addFlavorNow(Flavor.HOT);
        String actual;
        String expected="HOT";
        actual = wings.getFlavorChoice();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testShouldReturnCheesyBreadSticks(){
        CheesyBreadSticks side = new CheesyBreadSticks("Cheesy Breadsticks", 10.00);
        String actual;
        String expected = "Cheesy Breadsticks";
        actual=side.getName();
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void testShouldReturnComboPriceEquals20(){
        Pizza pizza = new Pizza("Cheese","Small",10.00);
        CheesyBreadSticks side = new CheesyBreadSticks("CheesyBreadSticks", 10.00);
        Drink drink = new Drink("Coke", 5.00);
        Combo combo = new Combo("Small",pizza,side,drink);
        Double actual;
        actual = combo.getPrice();
        Double expected = 20.00;
        Assert.assertEquals(actual,expected);
    }
}
