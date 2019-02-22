package ru.alexey.biginteger.baseData;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PrimeDao {
    @Query("SELECT prime FROM primes")
    List<String> getAll();

    @Insert
    void insert(List<Primes> primes);
}
