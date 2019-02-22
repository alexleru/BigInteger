package ru.alexey.biginteger.baseData;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Primes.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PrimeDao primeDao();
}
