package com.teksystems.bootcamp.capstone2.Start;
import com.teksystems.bootcamp.capstone2.Logic.CheckOut.CheckOut;
import com.teksystems.bootcamp.capstone2.Exit.Exit;
import com.teksystems.bootcamp.capstone2.Menu.Menu;
import com.teksystems.bootcamp.capstone2.Logic.Order.Order;
import com.teksystems.bootcamp.capstone2.Logic.Receipt.ReceiptStorage;

import java.util.Scanner;

public class Start {
    public static void start(){
        Scanner scanner = new Scanner(System.in);
        String option;

        System.out.println(Menu.image);
        greeting();
        while (scanner.hasNext()) {
            option = scanner.next();
            if(option.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+") ){
                Start.clear();
                System.out.println("You Entered an Invalid Option\n");
                start();
            }
            if (Integer.parseInt(option) == 1) {
                Order.orderIntro();
            }
            if(Integer.parseInt(option) == 2){
                Start.clear();
                System.out.println(Menu.receiptImg);
                ReceiptStorage.findIntro();
            }
            if (Integer.parseInt(option) == 3){
                Start.clear();
                CheckOut.checkout();
                System.out.println("\n");

            }
            if (Integer.parseInt(option) == 4){
                Exit.exit();
            }
            if(Integer.parseInt(option)>4){
                System.out.println("You Entered an Invalid Option");
                start();
            }

        }


    }

    private static void greeting() {
        System.out.println("Welcome to Pizza Bytes");
        System.out.println("Press 1 for Menu" + "\n" + "Press 2 for Receipt Lookup" + "\n" + "Press 3 to View Current Order" + "\n" + "Press 4 to terminate transaction");
    }
    public static void clear(){
        for(int i = 0; i<30; i++){
            System.out.println("\n");
        }
    }

}
