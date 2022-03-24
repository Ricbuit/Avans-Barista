package com.example.avansbarista;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avansbarista.adapters.CoffeeAdapter;
import com.example.avansbarista.models.Coffee;
import com.example.avansbarista.viewmodels.CoffeeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CoffeeViewModel coffeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        CoffeeAdapter adapter = new CoffeeAdapter();
        recyclerView.setAdapter(adapter);

        coffeeViewModel = new ViewModelProvider(this).get(CoffeeViewModel.class);
        coffeeViewModel.getAllCoffees().observe(this, new Observer<List<Coffee>>() {
            @Override
            public void onChanged(@Nullable List<Coffee> coffees) {
                adapter.setCoffees(coffees);
            }
        });
    }
}