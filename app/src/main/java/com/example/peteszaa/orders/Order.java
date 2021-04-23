package com.example.peteszaa.orders;

import java.util.ArrayList;


/**
 * An item representing an Order.
 */
public class Order {
    public final String id;
    public String crust;
    public String sauce;
    public ArrayList<String> toppings;
    public String price;

    static int ORDERNUM = 2344;

    public Order(String crust, String sauce, String[] toppings, String price) {
        this.id = Integer.toString(ORDERNUM);
        ORDERNUM += ORDERNUM % 10 == 0 ? 1 : ORDERNUM % 10;
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = new ArrayList<String>();
        for(String s: toppings) {
            this.toppings.add(s);
        }
        this.price = price;
    }

    public Order(String id, String crust, String sauce, String[] toppings, String price) {
        this.id = id;
        ORDERNUM = Integer.parseInt(id);
        ORDERNUM += ORDERNUM % 10 == 0 ? 1 : ORDERNUM % 10;
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = new ArrayList<String>();
        for(String s: toppings) {
            this.toppings.add(s);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return id + price;
    }
}