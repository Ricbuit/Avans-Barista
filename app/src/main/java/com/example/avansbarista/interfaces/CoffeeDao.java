package com.example.avansbarista.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.avansbarista.models.Coffee;

import java.util.List;

@Dao
public interface CoffeeDao {

    @Insert
    void insert(Coffee coffee);

    @Update
    void update(Coffee coffee);

    @Delete
    void delete(Coffee coffee);

    @Query("DELETE FROM coffee_table")
    void deleteAllCoffees();

    @Query("SELECT * FROM coffee_table ORDER BY title DESC")
    LiveData<List<Coffee>> getAllCoffees();
}
