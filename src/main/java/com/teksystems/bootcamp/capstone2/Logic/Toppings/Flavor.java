package com.teksystems.bootcamp.capstone2.Logic.Toppings;

import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;

import java.util.Scanner;

public enum Flavor {
    MILD("Mild"),
    HOT("Hot"),
    LEMON_PEPPER("Lemon Pepper"),
    GARLIC_PEPPER("Garlic Pepper"),
    BBQ("BBQ"),
    GHOST_PEPPER("Ghost Pepper"),
    UN_GODLY("Un-Godly"),
    PLAIN("Plain");

    private String name;

    Flavor(String name){
        this.name=name;
    }

    public static Wings addFlavor(Wings wings) {
        System.out.println("Please Select a Flavor");
        System.out.println("1. Mild" + "\n" +
                "2. Hot" + "\n" +
                "3. Lemon Pepper" + "\n" +
                "4. Garlic Pepper" + "\n" +
                "5. BBQ" + "\n" +
                "6. Ghost Pepper" + "\n" +
                "7. Un-Godly");


        Scanner scanner = new Scanner(System.in);
        String flavor = scanner.next();
        if(flavor.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")){
            System.out.println("You chose Plain Wings");
            wings.addFlavorNow(PLAIN);
            return wings;
        }
        if (Integer.parseInt(flavor) == 1) {
            System.out.println("You Chose Mild");
            wings.addFlavorNow(MILD);
            return wings;
        }
        if (Integer.parseInt(flavor) == 2) {
            System.out.println("You Chose Hot");
            wings.addFlavorNow(HOT);
            return wings;
        }
        if (Integer.parseInt(flavor) == 3) {
            System.out.println("You Chose Lemon Pepper");
            wings.addFlavorNow(LEMON_PEPPER);
            return wings;
        }
        if (Integer.parseInt(flavor) == 4) {
            System.out.println("You Chose Garlic Pepper");
            wings.addFlavorNow(GARLIC_PEPPER);
            return wings;
        }
        if (Integer.parseInt(flavor) == 5) {
            System.out.println("You Chose BBQ");
            wings.addFlavorNow(BBQ);
            return wings;
        }
        if (Integer.parseInt(flavor) == 6) {
            System.out.println("You Chose Ghost Pepper");
            wings.addFlavorNow(GHOST_PEPPER);
            return wings;
        }
        if (Integer.parseInt(flavor) == 7) {
            System.out.println("You Chose Un-Godly");
            wings.addFlavorNow(UN_GODLY);
            return wings;
        }if(Integer.parseInt(flavor)>7){
            addFlavor(wings);
        }
        if(Integer.parseInt(flavor)<1){
            addFlavor(wings);
        }
        return wings;
    }
}


