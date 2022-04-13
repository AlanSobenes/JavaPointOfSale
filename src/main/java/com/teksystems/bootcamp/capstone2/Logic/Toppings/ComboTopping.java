package com.teksystems.bootcamp.capstone2.Logic.Toppings;

import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;

import java.util.Scanner;

public enum ComboTopping {

        SAUSAGE("Sausage"),
        PEPPERONI("Pepperoni"),
        ONION("Onion"),
        MUSHROOM("Mushroom"),
        BACON("Bacon"),
        EXTRA_CHEESE("Extra Cheese"),
        NO_TOPPING("No Toppings");

        private String name;

        ComboTopping(String name) {
            this.name = name;

        }

        public String getName() {
            return name;
        }

        public static void add2Tops() {
            System.out.println("Please Select 2 Toppings");
            System.out.println("1. Sausage" + "\n" +
                    "2. Pepperoni" + "\n" +
                    "3. Onion" + "\n" +
                    "4. Mushroom" + "\n" +
                    "5. Bacon" + "\n" +
                    "6. Extra Cheese");
        }
    public static void add3Tops() {
        System.out.println("Please Select 3 Toppings");
        System.out.println("1. Sausage" + "\n" +
                "2. Pepperoni" + "\n" +
                "3. Onion" + "\n" +
                "4. Mushroom" + "\n" +
                "5. Bacon" + "\n" +
                "6. Extra Cheese");
    }
        public static Pizza topThePizza(Pizza pizza){
            Scanner scanner = new Scanner(System.in);
            String topping = scanner.next();
            if(topping.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+") ){
                System.out.println("You selected no toppings");
                pizza.addComboToppings(NO_TOPPING);
               return pizza;
            }
            if (Integer.parseInt(topping) == 1) {
                System.out.println("You Added Sausage to your Pizza");
                pizza.addComboToppings(SAUSAGE);
                if(pizza.getSize()=="Extra Large"&&pizza.getComboToppings().size()<3){
                    topThePizza(pizza);
                }else {
                    if(pizza.getComboToppings().size()<2){
                        topThePizza(pizza);
                    }
                }
                return pizza;
            }
             if (Integer.parseInt(topping) == 2) {
                System.out.println("You Added Pepperoni to your Pizza");
                 pizza.addComboToppings(PEPPERONI);
                 if(pizza.getSize()=="Extra Large"&&pizza.getComboToppings().size()<3){
                     topThePizza(pizza);
                 }else {
                     if(pizza.getComboToppings().size()<2){
                         topThePizza(pizza);
                     }
                 }
                 return pizza;
             } if (Integer.parseInt(topping) == 3) {
                System.out.println("You Added Onion to your Pizza");
                pizza.addComboToppings(ONION);
                if(pizza.getSize()=="Extra Large"&&pizza.getComboToppings().size()<3){
                    topThePizza(pizza);
                }else {
                    if(pizza.getComboToppings().size()<2){
                        topThePizza(pizza);
                    }
                }
                return pizza;
            } if (Integer.parseInt(topping) == 4) {
                System.out.println("You Added Mushroom to your Pizza");
                pizza.addComboToppings(MUSHROOM);
                if(pizza.getSize()=="Extra Large"&&pizza.getComboToppings().size()<3){
                    topThePizza(pizza);
                }else {
                    if(pizza.getComboToppings().size()<2){
                        topThePizza(pizza);
                    }
                }
                return pizza;
            }if (Integer.parseInt(topping) == 5) {
                System.out.println("You Added Bacon to your Pizza");
                pizza.addComboToppings(BACON);
                if(pizza.getSize()=="Extra Large"&&pizza.getComboToppings().size()<3){
                    topThePizza(pizza);
                }else {
                    if(pizza.getComboToppings().size()<2){
                        topThePizza(pizza);
                    }
                }
                return pizza;
            } if (Integer.parseInt(topping) == 6) {
                System.out.println("You Added Extra Cheese to your Pizza");
                pizza.addComboToppings(EXTRA_CHEESE);
                if(pizza.getSize()=="Extra Large"&&pizza.getComboToppings().size()<3){
                    topThePizza(pizza);
                }else {
                    if(pizza.getComboToppings().size()<2){
                        topThePizza(pizza);
                    }
                }
                return pizza;
            } if(Integer.parseInt(topping)>6) {
                System.out.println("Please Select A Topping");
                topThePizza(pizza);
            }
            return pizza;
        }
}

