package com.example.carmaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyCar extends AppCompatActivity {

    Button MyCar_btn_Services, MyCar_btn_TotalExpenses;
    TextView dispName;
    TextView dispModel;
    TextView dispLicenseplate;
    TextView dispYear;
    TextView dispBrand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);
        getSupportActionBar().hide();

        MyCar_btn_Services = findViewById(R.id.MyCar_btn_Services);
        MyCar_btn_TotalExpenses = findViewById(R.id.MyCar_btn_TotalExpenses);
        dispName=findViewById(R.id.MyCar_Name);
        dispBrand=findViewById(R.id.MyCar_Brand);
        dispModel=findViewById(R.id.MyCar_Model);
        dispLicenseplate=findViewById(R.id.MyCar_LicensePlate);
        dispYear=findViewById(R.id.MyCar_Year);

        Intent intent = getIntent();
        dispName.setText(intent.getStringExtra("namecar"));
        dispModel.setText(intent.getStringExtra("modelcar"));
        dispYear.setText(intent.getStringExtra("yearcar"));
        dispBrand.setText(intent.getStringExtra("brandcar"));
        dispLicenseplate.setText(intent.getStringExtra("licensePlatecar"));

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