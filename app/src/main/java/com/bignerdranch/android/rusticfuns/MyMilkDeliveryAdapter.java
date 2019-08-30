package com.bignerdranch.android.rusticfuns;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dmelechow on 8/16/2019.
 */
public class MyMilkDeliveryAdapter extends RecyclerView.Adapter<MyMilkDeliveryAdapter.MyViewHolder> {


    List<MilkDeliver> milkDeliveryList;
    private int mRecentlyDeletedItemPosition;
    private Object mRecentlyDeletedItem;

    public String getFormatedDate(Date date) {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public void setMilkDeliveryList(List<MilkDeliver> milkDeliveryList) {
        this.milkDeliveryList = milkDeliveryList;
        notifyDataSetChanged();
    }

    @Override
    public MyMilkDeliveryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);


        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.milkPriceTextView.setText(Double.toString(milkDeliveryList.get(position).getMilkPrice()) + " Рублей");
        holder.amountOfMilkTextView.setText(Double.toString(milkDeliveryList.get(position).getTheNumbeOfLitersOfMilk()) + " Литров ");
        holder.dateTextView.setText(  getFormatedDate(milkDeliveryList.get(position).getDate()));
        holder.totalAmountTextView.setText("Общая сумма " + (Double.toString(milkDeliveryList.get(position).getTheNumbeOfLitersOfMilk()
                * (milkDeliveryList.get(position).getMilkPrice()))) + " Рублей ");


    }

    @Override
    public int getItemCount() {
        return milkDeliveryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView milkPriceTextView;
        public TextView amountOfMilkTextView;
        public TextView dateTextView;
        public TextView totalAmountTextView;

        public MyViewHolder(View v) {
            super(v);

            milkPriceTextView = v.findViewById(R.id.milkPriceTextView);
            amountOfMilkTextView = v.findViewById(R.id.amountOfMilkTextView);
            dateTextView = v.findViewById(R.id.dateTextViewt);
            totalAmountTextView = v.findViewById(R.id.totalAmountTextView);
        }
    }
}

