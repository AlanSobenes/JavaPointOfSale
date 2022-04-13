package com.teksystems.bootcamp.capstone2.Logic.Cart;

import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.CheesyBreadSticks;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Side;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;
import com.teksystems.bootcamp.capstone2.Menu.Menu;
import com.teksystems.bootcamp.capstone2.Start.Start;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.ComboTopping;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.Flavor;
import com.teksystems.bootcamp.capstone2.Logic.Combos.Combo;

import java.util.Scanner;


public class ComboCartCrud {
    public static void add() {
        Scanner scanner = new Scanner(System.in);
        String itemId;
            System.out.println("Enter The Combo Number You Would Like To Add To Your Order: ");
            System.out.println("Or Enter 999 to Return");
            itemId = scanner.next();
            if (itemId.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")) {
                System.out.println("You Entered an Invalid Option");
                add();
            }
            if (Integer.parseInt(itemId) == 1) {
                System.out.println("You Have Selected A Small 2 Topping Pizza with a Side and Drink");
                Pizza small2Top = new Pizza("Cheese", "Small", 0.00);
                ComboTopping.add2Tops();
                Pizza toppedPizza = ComboTopping.topThePizza(small2Top);
                Side side = chooseSide();
                Drink drink = chooseDrink();
                Combo combo = new Combo("Small",toppedPizza, side, drink);
                Cart.setOrderList(combo);
                Start.clear();
                Cart.showCart();
                Menu.combos();
                Cart.goComboCart();
            }
            if (Integer.parseInt(itemId) == 2) {
                System.out.println("You Have Selected A Medium 2 Topping Pizza with a Side and Drink");
                Pizza small2Top = new Pizza("Cheese", "Medium", 0.00);
                ComboTopping.add2Tops();
                Pizza toppedPizza = ComboTopping.topThePizza(small2Top);
                Side side = chooseSide();
                Drink drink = chooseDrink();
                Combo combo = new Combo("Medium",toppedPizza, side, drink);
                Cart.setOrderList(combo);
                Start.clear();
                Cart.showCart();
                Menu.combos();
                Cart.goComboCart();
            }
            if (Integer.parseInt(itemId) == 3) {
                System.out.println("You Have Selected A Large 2 Topping Pizza with a Side and Drink");
                Pizza small2Top = new Pizza("Cheese", "Large", 0.00);
                ComboTopping.add2Tops();
                Pizza toppedPizza = ComboTopping.topThePizza(small2Top);
                Side side = chooseSide();
                Drink drink = chooseDrink();
                Combo combo = new Combo("Large",toppedPizza, side, drink);
                Cart.setOrderList(combo);
                Start.clear();
                Cart.showCart();
                Menu.combos();
                Cart.goComboCart();
            }
            if (Integer.parseInt(itemId) == 4) {
                System.out.println("You Have Selected An Extra Large 3 Topping Pizza with a Side and Drink");
                Pizza small2Top = new Pizza("Cheese", "Extra Large", 0.00);
                ComboTopping.add3Tops();
                Pizza toppedPizza = ComboTopping.topThePizza(small2Top);
                Side side = chooseSide();
                Drink drink = chooseDrink();
                Combo combo = new Combo("Extra Large",toppedPizza, side, drink);
                Cart.setOrderList(combo);
                Start.clear();
                Cart.showCart();
                Menu.combos();
                Cart.goComboCart();
            }
            if (Integer.parseInt(itemId)>4) {
            System.out.println("You Entered an Invalid Option");
            add();
        }

            if (Integer.parseInt(itemId) == 999) {
                Start.clear();
                Menu.combos();
                Cart.goComboCart();
        }
    }

    public static Side chooseSide(){
        System.out.println(" ");
        System.out.println("Please Choose a Side");
        System.out.println("1. For Chicken Wings"+"\n"+"2. For Cheesy Bread Sticks");
        Scanner scanner = new Scanner(System.in);
        String side = scanner.next();
        if (side.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")) {
            System.out.println("You Entered an Invalid Option");
            chooseSide();
        }if (Integer.parseInt(side)==1){
            Wings wings = new Wings("Wings", 10.00);
            Wings flavor = Flavor.addFlavor(wings);
            return flavor;
        }if (Integer.parseInt(side)==2){
            System.out.println("You Chose Cheesy Bread Sticks");
            CheesyBreadSticks cheesyBreadSticks = new CheesyBreadSticks("Cheesy Bread Sticks", 0.00);
            return cheesyBreadSticks;
        }if (Integer.parseInt(side)!=1&&Integer.parseInt(side)!=2){
            System.out.println("Please Choose a Side");
            chooseSide();
        }
         Side noSide = new Side("No Side", 0.00) {
             @Override
             public void addFlavorNow(Flavor flavor) {

             }
         };
        return noSide;
    }
    public static Drink chooseDrink(){
        System.out.println(" ");
        System.out.println("Please Choose a Drink");
        System.out.println("1. For Coke"+"\n"
                +"2. For Pepsi"+"\n"
                +"3. For Cherry Coke"+"\n"
                +"4. For Sprite");
        Scanner scanner = new Scanner(System.in);
        String drinkChoice= scanner.next();
        if (drinkChoice.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")) {
            System.out.println("You chose no drink");
            Drink drink = new Drink("no drink");
            return drink;
        }
        if(Integer.parseInt(drinkChoice)==1){
            System.out.println("You chose Coke");
            Drink drink = new Drink("Coke");
            return drink;
        }
        if(Integer.parseInt(drinkChoice)==2){
            System.out.println("You chose Pepsi");
            Drink drink = new Drink("Pepsi");
            return drink;
        }
        if(Integer.parseInt(drinkChoice)==3){
            System.out.println("You chose Cherry Coke");
            Drink drink = new Drink("Cherry Coke");
            return drink;
        }
        if(Integer.parseInt(drinkChoice)==4){
            System.out.println("You chose Sprite");
            Drink drink = new Drink("Sprite");
            return drink;
        }
        if(Integer.parseInt(drinkChoice)>4){
            System.out.println("Please Choose a Drink");
            chooseDrink();
        }
        if(Integer.parseInt(drinkChoice)<1) {
            System.out.println("Please Choose a Drink");
            chooseDrink();
        }
        Drink none = new Drink("none");
        return none;
    }
}
