package com.bignerdranch.android.rusticfuns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1;
        ListView listView;
        ArrayAdapter<String> adapter;
        ArrayList cats = new ArrayList();
        Scanner sc = new Scanner(System.in);
        cats.add(new String[Integer.parseInt(sc.nextLine())]);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cats);
        

    }
}
