package com.example.carmaintenance;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExpensesFragment extends Fragment {

    List<Service> serviceList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter RecyclerAdapter;
    SqliteDB_helper sqliteDB_helper;

    public ExpensesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        sqliteDB_helper = new SqliteDB_helper(getContext());

        viewDataOnTextView();

        return view;
    }

    public void viewDataOnTextView() {
        Cursor eachRecord_cursor = sqliteDB_helper.getServiceData();
        if (eachRecord_cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No record", Toast.LENGTH_SHORT).show();
            return;
        }
        while (eachRecord_cursor.moveToNext()) {
            String date, distance, type, cost;
            date = "Date: "+eachRecord_cursor.getString(0);
            distance = eachRecord_cursor.getString(1)+" km";
            type = eachRecord_cursor.getString(2);
            cost = "RS. "+eachRecord_cursor.getString(3);

            serviceList.add(new Service(date, distance, type, cost));
            RecyclerAdapter = new RecyclerViewAdapter(serviceList, getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(RecyclerAdapter);
        }
    }

}