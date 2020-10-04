package com.example.locationreminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btn_buy_gross;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_buy_gross = findViewById(R.id.buttonBuyGrocery);

        btn_buy_gross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.locationreminder.HomeActivity.this, com.example.locationreminder.BuyGrocery.class);
                startActivity(intent);
            }
        });

    }
}
