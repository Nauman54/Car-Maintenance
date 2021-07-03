package com.example.carmaintenance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Service> serviceList;
    Context context;

    public RecyclerViewAdapter(List<Service> serviceList, Context context) {
        this.serviceList = serviceList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Service service = serviceList.get(position);
        holder.date.setText(service.getDate());
        holder.distance.setText(service.getDistance());
        holder.type.setText(service.getType());
        holder.cost.setText(service.getCost());
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView date, distance, type, cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.tv_date);
            distance=itemView.findViewById(R.id.tv_distance);
            type=itemView.findViewById(R.id.tv_type);
            cost=itemView.findViewById(R.id.tv_cost);

        }
    }
}
