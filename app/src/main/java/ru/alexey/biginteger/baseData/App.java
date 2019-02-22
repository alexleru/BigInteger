package ru.alexey.biginteger.baseData;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

public class App extends Application {
    public static App instance;
    private AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBase = Room.databaseBuilder(this, AppDataBase.class, "primes")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance(){
        return instance;
    }

    public AppDataBase getDataBase(){
        return dataBase;
    }
}
