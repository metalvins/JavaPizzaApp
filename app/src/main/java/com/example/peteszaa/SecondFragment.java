package com.example.peteszaa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.peteszaa.orders.Order;
import com.example.peteszaa.orders.OrderList;

import java.math.BigDecimal;

public class SecondFragment extends Fragment {
    View v;
    BigDecimal crustPrice = BigDecimal.valueOf(0.0);
    BigDecimal saucePrice = BigDecimal.valueOf(0.0);
    BigDecimal toppingPrice = BigDecimal.valueOf(0.0);

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v = view;
        BigDecimal total = crustPrice.add(saucePrice).add(toppingPrice);
        ((EditText)view.findViewById(R.id.total)).setText(Double.toString(total.doubleValue()));

        ((CheckBox)view.findViewById(R.id.pepperoni)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(2.79));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(2.79));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
        });
        ((CheckBox)view.findViewById(R.id.chicken)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(2.23));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(2.23));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });
        ((CheckBox)view.findViewById(R.id.sausage)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(3.04));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(3.04));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });
        ((CheckBox)view.findViewById(R.id.peppers)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(1.67));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(1.67));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });
        ((CheckBox)view.findViewById(R.id.onion)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(1.78));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(1.78));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });
        ((CheckBox)view.findViewById(R.id.mushroom)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(2.16));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(2.16));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });
        ((Switch)view.findViewById(R.id.packpunch)).setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(isChecked) {
                        toppingPrice = toppingPrice.add(BigDecimal.valueOf(3.49));
                    } else {
                        toppingPrice = toppingPrice.subtract(BigDecimal.valueOf(3.49));
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });

        ((RadioGroup)view.findViewById(R.id.crustType)).setOnCheckedChangeListener(
                (group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.panFried:
                            crustPrice = BigDecimal.valueOf(1.45);
                            break;
                        case R.id.thinCrust:
                            crustPrice = BigDecimal.valueOf(1.86);
                            break;
                        case R.id.deepDish:
                            crustPrice = BigDecimal.valueOf(2.12);
                            break;
                        default:
                            crustPrice = BigDecimal.valueOf(-200.00);
                            break;
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });

        ((RadioGroup)view.findViewById(R.id.sauceType)).setOnCheckedChangeListener(
                (group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.noSauce:
                            saucePrice = BigDecimal.valueOf(0.0);
                            break;
                        case R.id.redSauce:
                            saucePrice = BigDecimal.valueOf(1.25);
                            break;
                        case R.id.whiteSauce:
                            saucePrice = BigDecimal.valueOf(1.76);
                            break;
                        default:
                            saucePrice = BigDecimal.valueOf(-200.00);
                            break;
                    }
                    BigDecimal price = crustPrice.add(saucePrice).add(toppingPrice);
                    ((EditText) view.findViewById(R.id.total)).setText(Double.toString(price.doubleValue()));
                });

        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.place).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String crust, sauce, price;
                String[] toppings;

                crust = getCrust(v.findViewById(R.id.crustType));
                sauce = getSauce(v.findViewById(R.id.sauceType));
                toppings = getToppings(v);
                price = getPrice(v.findViewById(R.id.total));
                Order order = new Order(crust, sauce, toppings, price);
                OrderList.ITEMS.add(order);
                OrderList.ITEM_MAP.put(order.id, order);

                SharedPreferences savePref = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
                String savedOrders = savePref.getString("savedOrders", "");
                SharedPreferences.Editor editor = savePref.edit();
                editor.putString("savedOrders", savedOrders + " " + makePrefString(order.id, crust, sauce, price, toppings));
                editor.apply();

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    private String makePrefString(String id, String crust, String sauce, String price, String[] toppings) {
        StringBuilder prefStr = new StringBuilder();
        prefStr.append(id);
        prefStr.append("#");
        switch (crust) {
            case "Pan":
                prefStr.append(1);
                break;
            case "ThinCrust":
                prefStr.append(2);
                break;
            case "DeepDish":
                prefStr.append(3);
                break;
            default:
                prefStr.append(-1);
        }
        prefStr.append(",");
        switch (sauce) {
            case "Red":
                prefStr.append(1);
                break;
            case "White":
                prefStr.append(2);
                break;
            case "None":
                prefStr.append(3);
                break;
            default:
                prefStr.append(-1);
        }
        prefStr.append(",");
        for(int i=0; i<toppings.length; i++) {
            if(toppings[i] == null) {
                break;
            }
            switch (toppings[i]) {
                case "Pepperoni":
                    prefStr.append(1);
                    break;
                case "Chicken":
                    prefStr.append(2);
                    break;
                case "Sausage":
                    prefStr.append(3);
                    break;
                case "Mushroom":
                    prefStr.append(4);
                    break;
                case "Onions":
                    prefStr.append(5);
                    break;
                case "Peppers":
                    prefStr.append(6);
                    break;
                case "PackAPunch":
                    prefStr.append(7);
                    break;
                default:
                    prefStr.append(-1);
            }
            prefStr.append(",");
        }
        if(prefStr.charAt(prefStr.length() - 1) == ',') {
            prefStr.deleteCharAt(prefStr.length() - 1);
        }

        prefStr.append(":");
        prefStr.append(price);
        return prefStr.toString();
    }

    private String getPrice(EditText viewById) {
        return viewById.getText().toString().trim();
    }

    private String[] getToppings(View view) {
        int toppingIndex = 0;
        String[] toppings = new String[7];
        if(view.findViewById(R.id.pepperoni).isSelected()) {
            toppings[toppingIndex++] = "Pepperoni";
        }
        if(view.findViewById(R.id.chicken).isSelected()) {
            toppings[toppingIndex++] = "Chicken";
        }
        if(view.findViewById(R.id.sausage).isSelected()) {
            toppings[toppingIndex++] = "Sausage";
        }
        if(view.findViewById(R.id.mushroom).isSelected()) {
            toppings[toppingIndex++] = "Mushroom";
        }
        if(view.findViewById(R.id.onion).isSelected()) {
            toppings[toppingIndex++] = "Onions";
        }
        if(view.findViewById(R.id.peppers).isSelected()) {
            toppings[toppingIndex++] = "Peppers";
        }
        if(view.findViewById(R.id.packpunch).isSelected()) {
            toppings[toppingIndex++] = "PackAPunch";
        }
        return toppings;
    }

    private String getCrust(RadioGroup viewById) {
        switch (viewById.getCheckedRadioButtonId()) {
            case R.id.panFried:
                return "Pan";
            case R.id.thinCrust:
                return "ThinCrust";
            case R.id.deepDish:
                return "DeepDish";
            default:
                return "Invalid";
        }
    }

    private String getSauce(RadioGroup viewById) {
        switch (viewById.getCheckedRadioButtonId()) {
            case R.id.redSauce:
                return "Red";
            case R.id.whiteSauce:
                return "White";
            case R.id.noSauce:
                return "None";
            default:
                return "Invalid";
        }
    }
}