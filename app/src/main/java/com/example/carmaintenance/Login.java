package com.example.carmaintenance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText text_username_login;
    EditText text_password_login;

    Button btn_login, btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        text_username_login = findViewById(R.id.Login_Username);
        text_password_login = findViewById(R.id.Login_Password);

        btn_login = findViewById(R.id.Login_btn);
        btn_register = findViewById(R.id.Register_btn);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateUsername() | !validatePassword()) {
                    return;
                } else {
                    validateUser();
                }

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void validateUser() {
        String user_enteredUsername = text_username_login.getText().toString().trim();
        String user_enteredPassword = text_password_login.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Accounts");

        Query checkUser = reference.orderByChild("username").equalTo(user_enteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    text_username_login.setError(null);

                    String passwordFromDB = snapshot.child(user_enteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(user_enteredPassword)) {

                        String nameFromDB = snapshot.child(user_enteredUsername).child("name").getValue(String.class);
                        text_username_login.setError(null);

                        Intent intent = new Intent(Login.this, Home.class);
                        intent.putExtra("name1",nameFromDB);
                        startActivity(intent);

                    } else {
                        text_password_login.setError("Wrong password");
                        text_password_login.requestFocus();
                    }
                } else {
                    text_username_login.setError("No user found");
                    text_username_login.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private Boolean validateUsername() {
        String val = text_username_login.getText().toString();


        if (val.isEmpty()) {
            text_username_login.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 11) {
            text_username_login.setError("Username too long");
            return false;
        } else {
            text_username_login.setError(null);

            return true;
        }
    }

    private Boolean validatePassword() {
        String val = text_password_login.getText().toString();

        if (val.isEmpty()) {
            text_password_login.setError("Field cannot be empty");
            return false;
        } else {
            text_password_login.setError(null);

            return true;
        }

    }


}