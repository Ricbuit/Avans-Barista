package com.example.avansbarista.databases;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.avansbarista.interfaces.CoffeeDao;
import com.example.avansbarista.models.Coffee;

import java.util.List;

public class CoffeeRepository {
    private CoffeeDao coffeeDao;
    private LiveData<List<Coffee>> allCoffees;

    public CoffeeRepository(Application application) {
        CoffeeDatabase database = CoffeeDatabase.getInstance(application);
        coffeeDao = database.coffeeDao();
        allCoffees = coffeeDao.getAllCoffees();
    }

    public void insert(Coffee coffee) {
        new InsertCoffeeAsyncTask(coffeeDao).execute(coffee);
    }

    public void update(Coffee coffee) {
        new UpdateCoffeeAsyncTask(coffeeDao).execute(coffee);
    }

    public void delete(Coffee coffee) {
        new DeleteCoffeeAsyncTask(coffeeDao).execute(coffee);
    }

    public void deleteAllCoffees() {
        new DeleteAllCoffeesCoffeeAsyncTask(coffeeDao).execute();
    }

    public LiveData<List<Coffee>> getAllCoffees() {
        return allCoffees;
    }

    private static class InsertCoffeeAsyncTask extends AsyncTask<Coffee, Void, Void> {
        private CoffeeDao coffeeDao;

        private InsertCoffeeAsyncTask(CoffeeDao coffeeDao) {
            this.coffeeDao = coffeeDao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            coffeeDao.insert(coffees[0]);
            return null;
        }
    }

    private static class UpdateCoffeeAsyncTask extends AsyncTask<Coffee, Void, Void> {
        private CoffeeDao coffeeDao;

        private UpdateCoffeeAsyncTask(CoffeeDao coffeeDao) {
            this.coffeeDao = coffeeDao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            coffeeDao.update(coffees[0]);
            return null;
        }
    }

    private static class DeleteCoffeeAsyncTask extends AsyncTask<Coffee, Void, Void> {
        private CoffeeDao coffeeDao;

        private DeleteCoffeeAsyncTask(CoffeeDao coffeeDao) {
            this.coffeeDao = coffeeDao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            coffeeDao.delete(coffees[0]);
            return null;
        }
    }

    private static class DeleteAllCoffeesCoffeeAsyncTask extends AsyncTask<Void, Void, Void> {
        private CoffeeDao coffeeDao;

        private DeleteAllCoffeesCoffeeAsyncTask(CoffeeDao coffeeDao) {
            this.coffeeDao = coffeeDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            coffeeDao.deleteAllCoffees();
            return null;
        }
    }
}
