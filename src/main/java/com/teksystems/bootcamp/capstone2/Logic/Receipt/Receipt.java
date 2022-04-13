package com.teksystems.bootcamp.capstone2.Logic.Receipt;

import com.teksystems.bootcamp.capstone2.Logic.Cart.Cart;
import com.teksystems.bootcamp.capstone2.Logic.Combos.Combo;
import com.teksystems.bootcamp.capstone2.Exit.Exit;
import com.teksystems.bootcamp.capstone2.Logic.Items.Drinks.Drink;
import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.CheesyBreadSticks;
import com.teksystems.bootcamp.capstone2.Logic.Items.Sides.Wings;
import com.teksystems.bootcamp.capstone2.Menu.Menu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    static Menu menu = new Menu();
    public static double receiptTotal = 0.00;

    public static double getReceiptTotal() {
        return receiptTotal;
    }

    public static void setReceiptTotal(double total) {
        Receipt.receiptTotal = total;
    }

    public static void printReceipt(double grandTotal) {
        setReceiptTotal(grandTotal);
        List<Item> order = Cart.getOrderList();
        Integer idx = ReceiptStorage.receipts.size();
        System.out.println(menu.thanksImage);
        DecimalFormat df = new DecimalFormat("0.00");
        double total = 0;
        System.out.println("");
        System.out.println("======================================= RECEIPT =============================================");
        System.out.println(" ");
        System.out.println("Order #"+(ReceiptStorage.receipts.size())+"\n");
        if (order.size() > 0) {
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
                            "$"
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
                            + (item.getSide().getFlavorChoice() == null ?"\n"+"   "+
                            item.getSide().getName() :"\n"+"   "+
                            item.getSide().getFlavorChoice() + " " + item.getSide().getName())
                            + " \n   " + item.getDrink().getName() + "          $ " + ((Combo) item).getPrice()
                    );
                    total = (total + ((Combo) item).getPrice());
                }

            }
                List<Item>storeCart = new ArrayList<>(order);
                ReceiptStorage.receipts.put(idx, storeCart);
                System.out.println("");
                System.out.println("Total:                                       $ " + df.format(total));
                System.out.println("Tax:                                         $ " + df.format(total * .08));
                System.out.println("Grand Total:                                 $ " + df.format(grandTotal) + "\n");
                System.out.println("==============================================================================================");
                Cart.getOrderList().clear();
                System.out.println(menu.thanks);
                Exit.exit();
            }
        }
    }

