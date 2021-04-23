package com.example.peteszaa;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.peteszaa.orders.Order;
import com.example.peteszaa.orders.OrderList;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences savePref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String savedOrder = savePref.getString("savedOrders", "");
        List<Order> orders = makeOrderList(savedOrder);
        if(orders.size() > 0) {
            OrderList.ITEMS.addAll(orders);
        }
    }

    private List<Order> makeOrderList(String savedOrder) {
        List<String> tokens = Arrays.asList(savedOrder.trim().split("\\s+"));
        List<Order> result = new ArrayList<Order>();
        for(String token: tokens) {
            if(!token.equals("")) {
                result.add(parseOrder(token));
            }
        }
        return result;
    }

    private Order parseOrder(String order) {
        List<String> orderId = Arrays.asList(order.split("#"));
        String id = orderId.get(0);
        List<String> priceOrderTokens = Arrays.asList(orderId.get(1).split(":"));
        List<String> tokens = Arrays.asList(priceOrderTokens.get(0).split(","));
        String price = priceOrderTokens.get(1).trim();
        String crust, sauce;
        String[] toppings  = new String[7];
        int i = 0;
        int toppingIndex = 0;
        switch (tokens.get(i++)) {
            case "1":
                crust = "Pan";
                break;
            case "2":
                crust = "ThinCrust";
                break;
            case "3":
                crust = "DeepDish";
                break;
            default:
                crust = "Invalid";
                break;
        }
        switch (tokens.get(i++)) {
            case "1":
                sauce = "Red";
                break;
            case "2":
                sauce = "White";
                break;
            case "3":
                sauce = "None";
                break;
            default:
                sauce = "Invalid";
                break;
        }
        while(toppingIndex < 7 && i < tokens.size()) {
            switch (tokens.get(i++)) {
                case "1":
                    toppings[toppingIndex++] = "Pepperoni";
                    break;
                case "2":
                    toppings[toppingIndex++] = "Chicken";
                    break;
                case "3":
                    toppings[toppingIndex++] = "Sausage";
                    break;
                case "4":
                    toppings[toppingIndex++] = "Mushroom";
                    break;
                case "5":
                    toppings[toppingIndex++] = "Onions";
                    break;
                case "6":
                    toppings[toppingIndex++] = "Peppers";
                    break;
                case "7":
                    toppings[toppingIndex++] = "PackAPunch";
                    break;
                default:
                    toppings[toppingIndex++] = "Invalid";
                    break;
            }
        }
        return new Order(id, crust, sauce, toppings, price);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}