package com.teksystems.bootcamp.capstone2.Logic.Receipt;

import com.teksystems.bootcamp.capstone2.Logic.Cart.Cart;
import com.teksystems.bootcamp.capstone2.Logic.Combos.Combo;
import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.CheesyBreadSticks;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;
import com.teksystems.bootcamp.capstone2.Start.Start;

import java.text.DecimalFormat;
import java.util.*;

public class ReceiptStorage {

    public static Map<Integer, List<Item>> receipts = new HashMap<>();


    public static void findIntro() {
        System.out.println("Please enter your order number or Enter 999 to return to the Main Menu");
        Scanner scanner = new Scanner(System.in);
        String orderNumber = scanner.next();
        if(orderNumber.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+") ){
            System.out.println("You Entered an Invalid Receipt Number");
            findIntro();

        }if(Integer.parseInt(orderNumber)<receipts.size()){
            findReceipt(Integer.parseInt(orderNumber));
        }if(Integer.parseInt(orderNumber)==999){
            Start.clear();
            Start.start();
        }else{
            System.out.println("You Entered an Invalid Receipt Number");
            findIntro();
        }
    }


    public static List<Item> findReceipt(Integer idx) {
        List<Item> order = receipts.get(idx);
        double total = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("");
        System.out.println("======================================= RECEIPT =============================================");
        System.out.println(" ");
        System.out.println("Order #" + idx);
        for (Item item : order) {
            if (item instanceof Pizza) {
                System.out.println((order.indexOf(item) ==
                                0 ? order.indexOf(item) + 1 : (order.indexOf(item)) + 1) + ". "
                                + (((Pizza) item).getSize() != "Extra Large" ? "A "
                                + ((Pizza) item).getSize() : "An "
                                + ((Pizza) item).getSize()) + " "
                                + (((Pizza) item).getName() != "Cheese" ? ((Pizza) item).getName() + " "
                                + item.type + " " : ((Pizza) item).getName() + " "
                                + item.type + " "
                                + (!((Pizza) item).getToppings().isEmpty() ? "with "
                                + ((Pizza) item).getToppings() + " " : "without toppings "))+
                                "          $ "
                                + ((Pizza) item).getPrice());
                total = (total + ((Pizza) item).getPrice());
            }
            if (item instanceof Drink) {
                System.out.println((order.indexOf(item) ==
                        0 ? order.indexOf(item) + 1 : (order.indexOf(item)) + 1)
                        + ". A 2 liter of " + ((Drink) item).getName()
                        + "          $ " + ((Drink) item).getPrice());
                total = (total + ((Drink) item).getPrice());
            }
            if (item instanceof Wings) {
                System.out.println((order.indexOf(item) ==
                        0 ? order.indexOf(item) + 1 : (order.indexOf(item)) + 1)
                        + ". 10 " + ((Wings) item).getFlavorChoice() + " " + ((Wings) item).getName()
                        + "          $ " + ((Wings) item).getPrice());
                total = (total + ((Wings) item).getPrice());
            }
            if (item instanceof CheesyBreadSticks) {
                System.out.println((order.indexOf(item) ==
                        0 ? order.indexOf(item) + 1 : (order.indexOf(item)) + 1)
                        + ". 10 " + ((CheesyBreadSticks) item).getName()
                        + "          $ " + ((CheesyBreadSticks) item).getPrice());
                total = (total + ((CheesyBreadSticks) item).getPrice());
            }
            if (item instanceof Combo) {
                System.out.println((order.indexOf(item) ==
                        0 ? order.indexOf(item) + 1 : (order.indexOf(item)) + 1)
                        + ". " + (item.getPizza().getSize() != "Extra Large" ?
                        "A " + item.getPizza().getSize() + " 2 Topping Pizza Combo with " + item.getPizza().getComboToppings() :
                        "An " + item.getPizza().getSize() + " 3 Topping Pizza Combo with "
                                + item.getPizza().getComboToppings())
                        + (item.getSide().getFlavorChoice() == null ? "\n" + "   " +
                        item.getSide().getName() : "\n" + "   " +
                        item.getSide().getFlavorChoice() + " " + item.getSide().getName())
                        + " \n   " + item.getDrink().getName() + "          $ " + ((Combo) item).getPrice()
                );
                total = (total + ((Combo) item).getPrice());
            }

        }
        System.out.println("");
        System.out.println("Total:                                       $ " + df.format(total));
        System.out.println("Tax:                                         $ " + df.format(total * .08));
        System.out.println("Grand Total:                                 $ " + df.format((total+(total*.08))) + "\n");
        System.out.println("==============================================================================================");
        Start.start();
        return order;
    }

}


