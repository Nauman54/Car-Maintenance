package com.example.carmaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button Home_btn_AddCar, Home_btn_MyCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        Home_btn_AddCar = findViewById(R.id.Home_btn_AddCar);
        Home_btn_MyCar = findViewById(R.id.Home_btn_MyCar);

        Home_btn_AddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move_to_addCar = new Intent(Home.this, AddCar.class);
                startActivity(move_to_addCar);
                finish();
            }
        });

        Home_btn_MyCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move_to_myCar = new Intent(Home.this, MyCar.class);
                startActivity(move_to_myCar);
                finish();
            }
        });

    }
}