package com.teksystems.bootcamp.capstone2.Logic.Order;

import com.teksystems.bootcamp.capstone2.Logic.Cart.Cart;
import com.teksystems.bootcamp.capstone2.Menu.Menu;
import com.teksystems.bootcamp.capstone2.Start.Start;

import java.util.Scanner;

public class Order {
    static Scanner scanner = new Scanner(System.in);
    static String menuOption;

    public static void orderIntro(){
        Start.clear();
        Menu.menu();
        System.out.println("Press 1 for Combos" + "\n" + "Press 2 for Items " + "\n" + "Press 3 to go Back");
        menuOption = scanner.next();
        if(menuOption.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+") ){
            orderIntro();
        }
        if(Integer.parseInt(menuOption) == 1){
            Start.clear();
            Menu.combos();
            Cart.goComboCart();

        }
        if(Integer.parseInt(menuOption) == 2){
            Start.clear();
            Menu.items();
            Cart.goItemCart();
        }
        if(Integer.parseInt(menuOption) == 3){
            Start.clear();
            Start.start();
        }if(Integer.parseInt(menuOption)>3){
            orderIntro();
        }

}



}
