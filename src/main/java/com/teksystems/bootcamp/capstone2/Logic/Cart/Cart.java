package com.teksystems.bootcamp.capstone2.Logic.Cart;

import com.teksystems.bootcamp.capstone2.Logic.CheckOut.CheckOut;
import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.CheesyBreadSticks;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;
import com.teksystems.bootcamp.capstone2.Logic.Combos.Combo;
import com.teksystems.bootcamp.capstone2.Menu.Menu;
import com.teksystems.bootcamp.capstone2.Logic.Order.Order;
import com.teksystems.bootcamp.capstone2.Start.Start;


import java.text.DecimalFormat;
import java.util.*;

public class Cart {
    static ItemCartCRUD crud = new ItemCartCRUD();
    static ComboCartCrud crud2 = new ComboCartCrud();
    public static List<Item> orderList = new ArrayList<>();

    private static double cartTotal = 0.00;

        public static void goItemCart() {
            System.out.println("Press 1 to Add an Item" + "\n" + "Press 2 to Go Back"+"\n"+"Press 3 to Checkout");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if(choice.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")){
                goItemCart();
            }
            if (Integer.parseInt(choice)==1){
                crud.add();
            }
            if(Integer.parseInt(choice)==2) {
                Order.orderIntro();
            }
            if(Integer.parseInt(choice)==3) {
                Start.clear();
                CheckOut.checkout();
            }
            if(Integer.parseInt(choice)>3){
                goItemCart();
            }
    }


    public static void goComboCart() {
        System.out.println("Press 1 to Add A Combo" + "\n" + "Press 2 to Go Back"+"\n"+"Press 3 to Checkout");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
            if(choice.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")){
                goComboCart();
            }
            if (Integer.parseInt(choice)==1){
                crud2.add();
            }
            if(Integer.parseInt(choice)==2) {
                Order.orderIntro();
            }
        if(Integer.parseInt(choice)==3) {
            Start.clear();
            CheckOut.checkout();
        }
            if(Integer.parseInt(choice)>3){
                goComboCart();
            }
    }




    public static double showCart() {
        double total = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(Menu.cartImg);
        System.out.println("================================================ CART =============================================================");
        System.out.println(" ");
        if (orderList.size() > 0) {
            for (Item item : orderList) {
                if (item instanceof Pizza) {
                    System.out.println((orderList.indexOf(item) ==
                            0 ? orderList.indexOf(item) + 1 : (orderList.indexOf(item))+1) + ". "
                            + (((Pizza) item).getSize() != "Extra Large" ? "A "
                            + ((Pizza) item).getSize() : "An "
                            + ((Pizza) item).getSize()) + " "
                            + (((Pizza) item).getName() != "Cheese" ? ((Pizza) item).getName() + " "
                            + item.type + " " : ((Pizza) item).getName() + " "
                            + item.type + " "
                            + (!((Pizza) item).getToppings().isEmpty() ? "with "
                            + ((Pizza) item).getToppings() + " " : "without toppings "))
                            + "             $ "
                            + ((Pizza) item).getPrice());
                   total = (total + ((Pizza) item).getPrice());
                }
                if (item instanceof Drink) {
                    System.out.println((orderList.indexOf(item) ==
                            0 ? orderList.indexOf(item) + 1 : (orderList.indexOf(item))+1)
                            + ". A 2 liter of " + ((Drink) item).getName()
                            + "             $ " + ((Drink) item).getPrice());
                    total = (total + ((Drink) item).getPrice());
                }
                if (item instanceof Wings) {
                    System.out.println((orderList.indexOf(item) ==
                            0 ? orderList.indexOf(item) + 1 : (orderList.indexOf(item))+1)
                            + ". Ten " + ((Wings) item).getFlavorChoice() + " " + ((Wings) item).getName()
                            + "             $ " + ((Wings) item).getPrice());
                    total = (total + ((Wings) item).getPrice());
                }
                if (item instanceof CheesyBreadSticks) {
                    System.out.println((orderList.indexOf(item) ==
                            0 ? orderList.indexOf(item) + 1 : (orderList.indexOf(item))+1)
                            + ". Ten " + ((CheesyBreadSticks) item).getName()
                            + "             $ " + ((CheesyBreadSticks) item).getPrice());
                    total = (total + ((CheesyBreadSticks) item).getPrice());
                }
                if (item instanceof Combo){
                    System.out.println((orderList.indexOf(item) ==
                            0 ? orderList.indexOf(item) + 1 : (orderList.indexOf(item))+1)
                            + ". " + (item.getPizza().getSize()!="Extra Large"?
                            "A "+ item.getPizza().getSize()+" 2 Topping Pizza with "+item.getPizza().getComboToppings():
                            "An "+item.getPizza().getSize()+" 3 Topping Pizza with "
                            +item.getPizza().getComboToppings())+", "
                            +(item.getSide().getFlavorChoice()==null?
                            item.getSide().getName():
                            item.getSide().getFlavorChoice()+" "+item.getSide().getName())
                            +" and a "+item.getDrink().getName()+"             $ "+ ((Combo) item).getPrice()
                    );
                    total=(total + ((Combo) item).getPrice());
                }
                setCartTotal(total);
            }
        } else {
            System.out.println("There Is Nothing In Your Cart");
            setCartTotal(0.00);
        }


        System.out.println(" ");
        System.out.println("========================================= Your Current Total is $" + df.format(total) + " ==============================================");
        System.out.println(" ");
        return total;
    }


    public static String sizeChoice() {
        String size = "";
        Scanner sizeScanner = new Scanner(System.in);
        String sizeOption = sizeScanner.next();
        if (sizeOption.matches("[A-zA-Z+\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\+\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\^\\_\\`\\~]+")) {
            System.out.println("You Entered an Invalid Option");
            System.out.println("Please Select a Size");
            return sizeChoice();
        }
        if (Integer.parseInt(sizeOption) == 1) {
            size = "Small";
            return size;
        }
        if (Integer.parseInt(sizeOption) == 2) {
            size = "Medium";
            return size;
        }
        if (Integer.parseInt(sizeOption) == 3) {
            size = "Large";
            return size;
        }
        if (Integer.parseInt(sizeOption) == 4) {
            size = "Extra Large";
            return size;
        }
        if (Integer.parseInt(sizeOption) != 1 &&
                Integer.parseInt(sizeOption) != 2 &&
                Integer.parseInt(sizeOption) != 3 &&
                Integer.parseInt(sizeOption) != 4) {
            System.out.println("You Entered an Invalid Option");
            System.out.println("Please Select a Size");
            return sizeChoice();
        }
        return size;
    }
    public static void setOrderList(Item item) {
        orderList.add(item);
    }

    public static List<Item> getOrderList() {
        return orderList;
    }

    public static void setCartTotal(double cartTotal) {
        Cart.cartTotal = cartTotal;
    }


    public double getCartTotal() {
        return cartTotal;
    }

}

