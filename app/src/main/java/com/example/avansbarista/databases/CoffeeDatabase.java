package com.example.avansbarista.databases;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.avansbarista.interfaces.CoffeeDao;
import com.example.avansbarista.models.Coffee;

@Database(entities = { Coffee.class }, version = 1)
public abstract class CoffeeDatabase extends RoomDatabase {

    private static CoffeeDatabase instance;

    public abstract CoffeeDao coffeeDao();

    public static synchronized  CoffeeDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CoffeeDatabase.class, "coffee_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CoffeeDao coffeeDao;

        private PopulateDbAsyncTask(CoffeeDatabase db) {
            coffeeDao = db.coffeeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            coffeeDao.insert(new Coffee("Americano", "With a similar flavor to black coffee, the americano consists of an espresso shot diluted in hot water.",0, false));
            coffeeDao.insert(new Coffee("Espresso", "An espresso shot can be served solo or used as the foundation of most coffee drinks, like lattes and macchiatos.",0, false));
            coffeeDao.insert(new Coffee("Macchiato", "The macchiato is another espresso-based drink that has a small amount of foam on top. It’s the happy medium between a cappuccino and a doppio.",0, false));
            return null;
        }
    }
}
