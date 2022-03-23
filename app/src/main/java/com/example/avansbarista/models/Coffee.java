package com.example.avansbarista.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "coffee_table")
public class Coffee {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private int sugarCubes;
    private boolean withMilk;

    public Coffee(String title, String description, int sugarCubes, boolean withMilk) {
        this.title = title;
        this.description = description;
        this.sugarCubes = sugarCubes;
        this.withMilk = withMilk;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getSugarCubes() {
        return sugarCubes;
    }

    public boolean isWithMilk() {
        return withMilk;
    }
}
