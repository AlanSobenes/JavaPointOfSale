package com.teksystems.bootcamp.capstone2.Logic.Toppings;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import java.util.Scanner;

public enum Topping {
    SAUSAGE("Sausage", 2.50),
    PEPPERONI("Pepperoni", 2.50),
    ONION("Onion", 2.50),
    MUSHROOM("Mushroom", 2.50),
    BACON("Bacon", 2.50),
    EXTRA_CHEESE("Extra Cheese", 2.50);

    private String name;
    private double cost;

    Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }

    public static Pizza showToppings(String name, String size,double price){
        Pizza pizza = new Pizza(name, size, 10.00);
        System.out.println("Would you like to add toppings?"+"\n"+"Enter Y for Yes "+"\n"+"Enter N for NO");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if(option.equalsIgnoreCase("y")) {
            System.out.println("Please Choose Your Toppings");
            System.out.println("1. Sausage" + "\n" +
                    "2. Pepperoni" + "\n" +
                    "3. Onion" + "\n" +
                    "4. Mushroom" + "\n" +
                    "5. Bacon" + "\n" +
                    "6. Extra Cheese" + "\n" +
                    "Enter 0 When Done");
            addToppingNow(pizza);
        } if(option.equalsIgnoreCase("n")){
            return pizza;
        }if(!(option.equalsIgnoreCase("y"))&&!(option.equalsIgnoreCase("n"))){
            System.out.println("Please Enter Y or N");
            showToppings(name, size,price);
        }
        return pizza;
    }
    public static Pizza addToppingNow(Pizza pizza){
        Scanner scanner1 = new Scanner(System.in);
        String topping = scanner1.next();
        if(topping.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+") ){
            System.out.println("You selected no toppings");
           return pizza;
        }
            if (Integer.parseInt(topping) == 1) {
                System.out.println("You Added Sausage to your Pizza");
                System.out.println( "Enter 0 When Done");
                pizza.addTopping(SAUSAGE);
                addToppingNow(pizza);
            } if (Integer.parseInt(topping) == 2) {
                System.out.println("You Added Pepperoni to your Pizza");
                System.out.println( "Enter 0 When Done");
                pizza.addTopping(PEPPERONI);
                addToppingNow(pizza);
            } if (Integer.parseInt(topping) == 3) {
                System.out.println("You Added Onion to your Pizza");
                System.out.println( "Enter 0 When Done");
                pizza.addTopping(ONION);
                addToppingNow(pizza);
            } if (Integer.parseInt(topping) == 4) {
                System.out.println("You Added Mushroom to your Pizza");
                System.out.println( "Enter 0 When Done");
                pizza.addTopping(MUSHROOM);
                addToppingNow(pizza);
            } if (Integer.parseInt(topping) == 5) {
                System.out.println("You Added Bacon to your Pizza");
                System.out.println( "Enter 0 When Done");
                pizza.addTopping(BACON);
                addToppingNow(pizza);
            } if (Integer.parseInt(topping) == 6) {
                System.out.println("You Added Extra Cheese to your Pizza");
                System.out.println( "Enter 0 When Done");
                pizza.addTopping(EXTRA_CHEESE);
                addToppingNow(pizza);
            } if (Integer.parseInt(topping) == 0) {
                return pizza;
            }

        return pizza;
    }


}
