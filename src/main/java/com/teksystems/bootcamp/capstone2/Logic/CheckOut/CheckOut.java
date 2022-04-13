package com.teksystems.bootcamp.capstone2.Logic.CheckOut;

import com.teksystems.bootcamp.capstone2.Logic.Cart.Cart;
import com.teksystems.bootcamp.capstone2.Logic.Receipt.Receipt;
import com.teksystems.bootcamp.capstone2.Start.Start;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CheckOut {
    public static void checkout(){
        if(Cart.getOrderList().isEmpty()){
            Cart.showCart();
        }
        if(!(Cart.getOrderList().isEmpty())){
            Cart checkoutCart = new Cart();
            DecimalFormat df = new DecimalFormat("0.00");
            checkoutCart.setCartTotal(Cart.showCart());
            System.out.println("Are you ready to Checkout?");
            System.out.println("Enter Y for Yes and N for No");
            Scanner scanner = new Scanner(System.in);
            String checkout = scanner.next();
            if (checkout.matches("[0-9\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")){
                checkout();
            }
            if(checkout.equalsIgnoreCase("y")){
                System.out.println("========================================== CHECKOUT ================================================================");
                System.out.println();
                System.out.println("Total:                                       $ " + df.format(checkoutCart.getCartTotal()));
                System.out.println("Tax:                                         $ " + df.format(checkoutCart.getCartTotal()*.08));
                System.out.println("Grand Total:                                 $ "+df.format(checkoutCart.getCartTotal()+(checkoutCart.getCartTotal()*.08))+"\n");

                System.out.println("Complete Transaction? \n"+
                        "Enter Y for yes and N for No");
                Scanner scanner2 = new Scanner(System.in);
                String complete = scanner2.next();
                if(complete.equalsIgnoreCase("y")){
                    Receipt.printReceipt((checkoutCart.getCartTotal()+(checkoutCart.getCartTotal()*.08)) );
                }
                else{
                    checkout();
                }
            }
            if(checkout.equalsIgnoreCase("n")) {
                System.out.println("Do You Want To Clear Your Cart?");
                System.out.println("**** Enter Y to Clear Cart **** \nOr Enter Any Key to Return To Main Menu");
                Scanner scanner3 = new Scanner(System.in);
                String clear = scanner3.next();
                if(clear.matches("[0-9+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")){
                    System.out.println("Ok, Come Back When Your Ready");
                    System.out.println("");
                    Start.start();
                }
                if (clear.equalsIgnoreCase("y")) {
                    Cart.getOrderList().clear();
                    Start.clear();
                    System.out.println("Your Cart has been Cleared!\n ");
                    Start.start();

                }
            }
        }
        else {
            Start.start();
        }
    }
}
