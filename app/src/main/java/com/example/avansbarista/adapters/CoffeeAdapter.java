package com.example.avansbarista.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avansbarista.R;
import com.example.avansbarista.models.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeHolder> {
    private List<Coffee> coffees = new ArrayList<>();

    @NonNull
    @Override
    public CoffeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coffee_item, parent, false);

        return new CoffeeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeHolder holder, int position) {
        Coffee currentCoffee = coffees.get(position);
        holder.textViewTitle.setText(currentCoffee.getTitle());
        holder.textViewDescription.setText(currentCoffee.getDescription());
    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
        notifyDataSetChanged();
    }

    class CoffeeHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;

        public CoffeeHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textview_title);
            textViewDescription = itemView.findViewById(R.id.textview_description);
        }
    }
}
