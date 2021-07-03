package com.example.carmaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCar extends AppCompatActivity {

    EditText text_name;
    EditText text_Model;
    EditText text_licensePlate;
    EditText text_Brand;
    EditText text_Year;

    FirebaseDatabase parentNode;
    DatabaseReference ref;

    Button btn_AddCarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        getSupportActionBar().hide();


        text_name = findViewById(R.id.AddCar_Name);
        text_licensePlate = findViewById(R.id.AddCar_LicensePlate);
        text_Model = findViewById(R.id.AddCar_Model);
        text_Brand = findViewById(R.id.AddCar_Brand);
        text_Year = findViewById(R.id.AddCar_Year);
        btn_AddCarInfo = findViewById(R.id.AddCar_btn_Add);

        btn_AddCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = text_name.getText().toString();
                String model = text_Model.getText().toString();
                String licensePlate = text_licensePlate.getText().toString();
                String brand = text_Brand.getText().toString();
                String year = text_Year.getText().toString();

                parentNode = FirebaseDatabase.getInstance();
                ref = parentNode.getReference("Cars");

                CarHelperClass helperClass = new CarHelperClass(name, licensePlate, model, brand, year);

                ref.child(name).setValue(helperClass);

                Intent intent = new Intent(AddCar.this, MyCar.class);
                intent.putExtra("namecar",name);
                intent.putExtra("modelcar",model);
                intent.putExtra("licensePlatecar",licensePlate);
                intent.putExtra("brandcar",brand);
                intent.putExtra("yearcar",year);
                startActivity(intent);
            }
        });

    }
    

}