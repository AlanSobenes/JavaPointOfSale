package com.teksystems.bootcamp.capstone2.Exit;

import com.teksystems.bootcamp.capstone2.Start.Start;

import java.util.Scanner;

public class Exit {
    public static void exit(){
        System.out.println("Exit Application?\n"+
                "Enter Y for yes and N for No");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.next();
        if(start.equalsIgnoreCase("y")){
            System.out.println("Thank you, see you soon!");
            System.exit(0);
        }if(start.equalsIgnoreCase("n")) {
            Start.clear();
            Start.start();

        }
    }
}
