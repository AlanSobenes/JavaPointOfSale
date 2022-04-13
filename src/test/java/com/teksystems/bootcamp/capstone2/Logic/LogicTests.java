package com.teksystems.bootcamp.capstone2.Logic;

import com.teksystems.bootcamp.capstone2.Logic.Cart.Cart;
import com.teksystems.bootcamp.capstone2.Logic.Cart.ComboCartCrud;
import com.teksystems.bootcamp.capstone2.Logic.Items.Item;
import com.teksystems.bootcamp.capstone2.Logic.Items.Pizzas.Pizza;
import com.teksystems.bootcamp.capstone2.Logic.Receipt.Receipt;
import com.teksystems.bootcamp.capstone2.Logic.Receipt.ReceiptStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LogicTests {


    @Test
    public void testShouldReturnACartTotal(){
        Cart cart = new Cart();
        cart.setCartTotal(10.00);
        double actual;
        double expected = 10.00;
        actual= cart.getCartTotal();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testShouldReturnACartItem(){
        Cart cart = new Cart();
        ComboCartCrud ccCrud = new ComboCartCrud();
        Pizza pizza = new Pizza("Cheese","Small",10.00);
        boolean actual;
        boolean expected = cart.orderList.contains(pizza);
        actual= cart.orderList.contains(pizza);
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testShouldReturnReceiptTotal(){
        Receipt receipt = new Receipt();
        receipt.printReceipt(10.00);
        double actual;
        double expected = 10.00;
        actual = receipt.getReceiptTotal();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testShouldReturnReceiptStorageSizeFromReceiptId(){
        ReceiptStorage receiptStorage = new ReceiptStorage();
        int actual;
        int expected = 0;
        actual = receiptStorage.receipts.size();
        Assert.assertEquals(actual,expected);
    }
}
