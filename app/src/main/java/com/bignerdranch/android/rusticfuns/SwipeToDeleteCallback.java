package com.bignerdranch.android.rusticfuns;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by dmelechow on 8/20/2019.
 */
public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    private MyMilkDeliveryAdapter  myMilkDeliveryAdapter ;
    public SwipeToDeleteCallback (MyMilkDeliveryAdapter  mmyMilkDeliveryAdapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        myMilkDeliveryAdapter = mmyMilkDeliveryAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();

        }
}
