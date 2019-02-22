package ru.alexey.biginteger.baseData;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Primes {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String prime;
}
