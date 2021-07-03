package com.example.carmaintenance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServicesFragment extends Fragment {

    EditText editText_date, editText_distance, editText_type, editText_cost;
    Button button_saveData;
    SqliteDB_helper sqliteDB_helper;

    public ServicesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        editText_date = view.findViewById(R.id.et_date);
        editText_distance = view.findViewById(R.id.et_distance);
        editText_type = view.findViewById(R.id.et_type);
        editText_cost = view.findViewById(R.id.et_cost);

        button_saveData = view.findViewById(R.id.btn_saveData);

        sqliteDB_helper = new SqliteDB_helper(getContext());

        button_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText_date.getText().toString();
                String name = editText_distance.getText().toString();
                String city = editText_type.getText().toString();
                String age = editText_cost.getText().toString();

                boolean checkSaved = sqliteDB_helper.insertServiceData(id, name, city, age);
                if (checkSaved == true) {
                    Toast.makeText(getContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Data Not Saved", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}