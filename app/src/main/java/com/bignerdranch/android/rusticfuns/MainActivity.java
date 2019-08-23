package com.bignerdranch.android.rusticfuns;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText amountOfMilkEditText, milkPrice;
    Activity activity = this;
    AppDatabase db;
    MilkDeliver milkDeliver = new MilkDeliver();
    DateConverter mConverters = new DateConverter();
  
    double num;
    float num1;
    float num3;
    double num2;
    private RecyclerView mRecyclerView;
    private MyMilkDeliveryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btAdd, btDel;
        db = Room.databaseBuilder(activity.getApplicationContext(),
                AppDatabase.class, "populus-database").allowMainThreadQueries().build();
        List<MilkDeliver> everyone = db.getMilkDao().getAllPmilk();

        amountOfMilkEditText = (EditText) findViewById(R.id.amountOfMilkEditText);
        milkPrice = (EditText) findViewById(R.id.milkPrice);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyMilkDeliveryAdapter();
        mAdapter.setMilkDeliveryList(everyone);
        mRecyclerView.setAdapter(mAdapter);
        btAdd = (Button) findViewById(R.id.btAdd);
        btDel = (Button) findViewById(R.id.btDel);
        btAdd.setOnClickListener(this);
        btDel.setOnClickListener(this);
        amountOfMilkEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                }
        });
        milkPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
        }
        private void setUpRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new SwipeToDeleteCallback(mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                if (!amountOfMilkEditText.getText().toString().isEmpty() && !milkPrice.getText().toString().isEmpty()) {
                    num1 = Float.parseFloat(amountOfMilkEditText.getText().toString());
                    num3 = Float.parseFloat(amountOfMilkEditText.getText().toString());
                    double num = (double) num1;
                    double num2 = (double) num3;

                        milkDeliver.setDate(cal);


                    milkDeliver.setMilkPrice(num2);
                    milkDeliver.setTheNumbeOfLitersOfMilk(num);
                    if (milkDeliver.getDate() != null && milkDeliver.getMilkPrice() != 0 && milkDeliver.getTheNumbeOfLitersOfMilk() != 0) {
                        Toast.makeText(activity, "Вы добавили запись", Toast.LENGTH_SHORT).show();
                        db.getMilkDao().insertAll(milkDeliver);
                        amountOfMilkEditText.setText("");
                        milkPrice.setText("");
                        } else {
                        Toast.makeText(activity, "Вы не ввели количество молока", Toast.LENGTH_SHORT).show();
                        }
                } else {
                    Toast.makeText(activity, "Вы не ввели количество молока", Toast.LENGTH_SHORT).show();
                }
        }
    }



}


