package com.example.peteszaa;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peteszaa.orders.Order;
import com.example.peteszaa.orders.OrderList;

import java.util.Arrays;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Order}.
 */
public class MyThirdRecyclerViewAdapter extends RecyclerView.Adapter<MyThirdRecyclerViewAdapter.ViewHolder> {

    private final List<Order> mValues;
    private final Fragment fragment;

    public MyThirdRecyclerViewAdapter(List<Order> items, ThirdFragment thirdFragment) {
        mValues = items;
        fragment = thirdFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.third_fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(Integer.toString(position+1) + ". Order Number " + mValues.get(position).id);
        holder.mContentView.setText("    $" + mValues.get(position).price);

        holder.itemView.findViewById(R.id.edit).setOnClickListener(v -> {
            Toast.makeText(fragment.getActivity(), "Go to second fragment and edit element at index " + position, Toast.LENGTH_LONG).show();
        });
        holder.itemView.findViewById(R.id.delete).setOnClickListener(v -> {
            String key = OrderList.ITEMS.get(position).id;
            OrderList.ITEMS.remove(position);
            OrderList.ITEM_MAP.remove(key);
            SharedPreferences savePref = PreferenceManager.getDefaultSharedPreferences(fragment.getActivity().getBaseContext());
            String savedOrders = savePref.getString("savedOrders", "");
            SharedPreferences.Editor editor = savePref.edit();
            editor.putString("savedOrders", removeOrder(savedOrders, key));
            editor.apply();
            notifyDataSetChanged();
        });

    }

    private String removeOrder(String savedOrders, String key) {
        List<String> tokens = Arrays.asList(savedOrders.trim().split("\\s+"));
        StringBuilder result = new StringBuilder();
        for(String token: tokens) {
            List<String> orderId = Arrays.asList(token.split("#"));
            String id = orderId.get(0);
            if(!id.equals(key)) {
                result.append(token);
                result.append(" ");
            }
        }
        return result.toString();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Order mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

}