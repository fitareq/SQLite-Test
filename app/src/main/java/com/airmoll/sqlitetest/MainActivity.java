package com.airmoll.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1, editText2;
    Button button, button1;

    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText  = findViewById(R.id.title);
        editText1  = findViewById(R.id.description);
        editText2 = findViewById(R.id.price);
        button = findViewById(R.id.addToCart);
        button1 = findViewById(R.id.goToCart);

        dbManager = new DBManager(this);
        dbManager.open();

        button.setOnClickListener(v ->{
            String title = editText.getText().toString();
            String description = editText1.getText().toString();
            String price = editText2.getText().toString();
            if (TextUtils.isEmpty(title))
                Toast.makeText(getApplicationContext(), "Title is required", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(description))
                Toast.makeText(getApplicationContext(), "Description is required", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(price))
                Toast.makeText(getApplicationContext(), "Price is required", Toast.LENGTH_SHORT).show();
            else {
                price = price + " BDT";
                dbManager.insert(title, description, price);
                dbManager.close();
                editText.setText("");
                editText1.setText("");
                editText2.setText("");
                editText.requestFocus();
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        button1.setOnClickListener(v1->{
            startActivity(new Intent(getApplicationContext(), CartActivity.class));
        });
    }
}