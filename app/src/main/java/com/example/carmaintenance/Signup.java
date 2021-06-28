package com.example.carmaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    EditText text_name;
    EditText text_username;
    EditText text_email;
    EditText text_password;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();


        text_name = findViewById(R.id.Signup_Name);
        text_email = findViewById(R.id.Signup_Email);
        text_username = findViewById(R.id.Signup_Username);
        text_password = findViewById(R.id.Signup_Password);
        btn_signup = findViewById(R.id.Signup_btn);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateName() | !validateUsername() | !validateEmail() | !validatePassword()) {
                    return;
                }

                String name = text_name.getText().toString();
                String username = text_username.getText().toString();
                String email = text_email.getText().toString();
                String password = text_password.getText().toString();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Accounts");

                UserHelperClass helperClass = new UserHelperClass(name, username, email, password);

                reference.child(username).setValue(helperClass);

                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });


    }


    private Boolean validateName() {
        String val = text_name.getText().toString();
        if (val.isEmpty()) {
            text_name.setError("Field cannot be empty");
            return false;
        } else {
            text_name.setError(null);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = text_username.getText().toString();
        String noWhiteSpace = "\\A\\w{2,20}\\z";


        if (val.isEmpty()) {
            text_username.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 11) {
            text_username.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            text_username.setError("No white spaces allowed");
            return false;
        } else {
            text_username.setError(null);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = text_email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            text_email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            text_email.setError("Invalid email address");
            return false;
        } else {
            text_email.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = text_password.getText().toString();

        if (val.isEmpty()) {
            text_password.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 7) {
            text_password.setError("Password too long");
            return false;
        } else {
            text_password.setError(null);
            return true;
        }
    }


}