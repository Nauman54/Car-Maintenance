package com.example.carmaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyCar extends AppCompatActivity {

    Button MyCar_btn_Services, MyCar_btn_TotalExpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        getSupportActionBar().hide();

        MyCar_btn_Services = findViewById(R.id.MyCar_btn_Services);
        MyCar_btn_TotalExpenses = findViewById(R.id.MyCar_btn_TotalExpenses);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new ServicesFragment()).commit();

        MyCar_btn_Services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ServicesFragment()).commit();
            }
        });

        MyCar_btn_TotalExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ExpensesFragment()).commit();
            }
        });

    }
}