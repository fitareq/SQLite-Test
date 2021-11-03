package com.airmoll.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    mAdapter adapter;
    private DBManager dbManager;
    List<DataClass> dataClasses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        dbManager = new DBManager(this);
        dbManager.open();

        Cursor cursor = dbManager.fetch();
        cursor.moveToFirst();

        while (!cursor.isAfterLast())
        {
            int indexTitle = cursor.getColumnIndex(DatabseHelper.TITLE);
            int indexDesc = cursor.getColumnIndex(DatabseHelper.DESCRIPTION);
            int indexPrice = cursor.getColumnIndex(DatabseHelper.PRICE);
            String title = cursor.getString(indexTitle);
            String desc = cursor.getString(indexDesc);
            String price = cursor.getString(indexPrice);
            dataClasses.add(new DataClass(title, desc, price));
            cursor.moveToNext();
        }

        adapter = new mAdapter(dataClasses);
        recyclerView.setAdapter(adapter);

    }
}