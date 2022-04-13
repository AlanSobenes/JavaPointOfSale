package com.teksystems.bootcamp.capstone2.Logic.Cart;

import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.MeatLoversPizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.SupremePizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.CheesyBreadSticks;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;
import com.teksystems.bootcamp.capstone2.Menu.Menu;
import com.teksystems.bootcamp.capstone2.Start.Start;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.Flavor;
import com.teksystems.bootcamp.capstone2.Logic.Toppings.Topping;


import java.util.*;


public class ItemCartCRUD {

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        String itemId;

            System.out.println("Enter The Item Number You Would Like To Add To Your Order: ");
            System.out.println("Or Enter 999 to Return");
            itemId = scanner.next();
            if (itemId.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")) {
                System.out.println("You Entered an Invalid Option");
                add();
            }
            if (Integer.parseInt(itemId) == 5) {
                Start.clear();
                System.out.println(Menu.pizzaImg);
                System.out.println("You Have Selected A Cheese Pizza" + "\n" + "Please Select a Size");
                System.out.println("1 for Small" + "\n" + "2 for Medium" + "\n" + "3 for Large" + "\n" + "4 for Extra Large");
                String size = Cart.sizeChoice();
                Pizza toppedPizza = Topping.showToppings("Cheese", size, 10.00);
                Cart.setOrderList(toppedPizza);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 6) {
                Start.clear();
                System.out.println(Menu.pizzaImg);
                System.out.println("You Have Selected A Supreme Pizza" + "\n" + "Please Select a Size");
                System.out.println("1 for Small" + "\n" + "2 for Medium" + "\n" + "3 for Large" + "\n" + "4 for Extra Large");
                String size = Cart.sizeChoice();
                SupremePizza supremePizza = new SupremePizza(size);
                Cart.setOrderList(supremePizza);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 7) {
                Start.clear();
                System.out.println(Menu.pizzaImg);
                System.out.println("You Have Selected A Meat Lovers Pizza" + "\n" + "Please Select a Size");
                System.out.println("1 for Small" + "\n" + "2 for Medium" + "\n" + "3 for Large" + "\n" + "4 for Extra Large");
                String size = Cart.sizeChoice();
                MeatLoversPizza meatLoversPizza = new MeatLoversPizza(size);
                Cart.setOrderList(meatLoversPizza);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 8) {
                Start.clear();
                CheesyBreadSticks cheesyBreadSticks = new CheesyBreadSticks("Cheesy Bread Sticks", 10.00);
                Cart.setOrderList(cheesyBreadSticks);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 9) {
                Start.clear();
                System.out.println(Menu.wingsImg);
                System.out.println("You Have Selected Ten Chicken Wings");
                Wings wings = new Wings("Wings", 10.00);
                Wings flavor = Flavor.addFlavor(wings);
                Cart.setOrderList(flavor);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }

            if (Integer.parseInt(itemId) == 10) {
                Start.clear();
                Drink drink = new Drink("Coke", 5.00);
                Cart.setOrderList(drink);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 11) {
                Start.clear();
                Drink drink = new Drink("Pepsi", 5.00);
                Cart.setOrderList(drink);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 12) {
                Start.clear();
                Drink drink = new Drink("Cherry Coke", 5.00);
                Cart.setOrderList(drink);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
            if (Integer.parseInt(itemId) == 13) {
                Start.clear();
                Drink drink = new Drink("Sprite", 5.00);
                Cart.setOrderList(drink);
                Start.clear();
                Cart.showCart();
                Menu.items();
                Cart.goItemCart();
            }
        if (Integer.parseInt(itemId)>13) {
            System.out.println("You Entered an Invalid Option");
            add();
        }
            if (Integer.parseInt(itemId) == 999) {
                Start.clear();
                Menu.items();
                Cart.goItemCart();
            }
        }
    }


