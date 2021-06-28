package com.example.carmaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AddCar extends AppCompatActivity {

    Button AddCar_btn_Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        AddCar_btn_Add = findViewById(R.id.AddCar_btn_Add);

    }
}