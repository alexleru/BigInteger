package ru.alexey.biginteger.Controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import ru.alexey.biginteger.baseData.App;
import ru.alexey.biginteger.baseData.AppDataBase;
import ru.alexey.biginteger.baseData.PrimeDao;
import ru.alexey.biginteger.baseData.Primes;

public class ControllerDataBase implements PrimeDao{
    AppDataBase dataBase = App.getInstance().getDataBase();
    PrimeDao primeDao = dataBase.primeDao();

    public List<String> getAll(){
        List<String> allValues;
        allValues = primeDao.getAll();
        return allValues;
    }

    public ArrayList<BigInteger> getAllBigIntegers(){
        List<String> allValues = getAll();
        ArrayList<BigInteger> bigIntegers = new ArrayList<>();
        for(String value : allValues){
            bigIntegers.add(new BigInteger(value));
        }
        return bigIntegers;
    }

    public void insert(List<Primes> primes){
        primeDao.insert(primes);
    }

    public int insertBig(ArrayList<BigInteger> bigIntegers){
        List<Primes> primes = new ArrayList<>();
        for (BigInteger bigInteger : bigIntegers){
            Primes prime = new Primes();
            prime.id = 0;
            prime.prime = bigInteger.toString();
            primes.add(prime);
        }
        insert(primes);
        return 0;
    }

}
