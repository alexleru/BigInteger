package ru.alexey.biginteger.baseData;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(indices = {@Index(value = {"prime"}, unique = true)})
public class Primes {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String prime;
}
