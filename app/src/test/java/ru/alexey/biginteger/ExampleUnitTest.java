package ru.alexey.biginteger;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import ru.alexey.biginteger.Calculation.PrimeNumbers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    ArrayList<BigInteger> bigIntegers;
    PrimeNumbers primeNumbers;
    ArrayList<BigInteger> resultBigIntegers;
    @Before
    public  void beforePrime(){
        bigIntegers = new ArrayList<>();
        bigIntegers.add(new BigInteger("3"));
        primeNumbers = new PrimeNumbers(bigIntegers);

        resultBigIntegers = new ArrayList<>();
        resultBigIntegers.add(new BigInteger("3"));
        resultBigIntegers.add(new BigInteger("5"));
        resultBigIntegers.add(new BigInteger("7"));
        resultBigIntegers.add(new BigInteger("11"));
        resultBigIntegers.add(new BigInteger("13"));
    }

    @Test
    public void testPrime() {
        primeNumbers.loop();
        bigIntegers = primeNumbers.getBigIntegerArrayList();

        Boolean result = true;
        for (int i = 0; i < bigIntegers.size(); i++){

            String bigInteger = bigIntegers.get(i).toString();
            String resulteBigInteger = resultBigIntegers.get(i).toString();

            if (!bigInteger.equals(resulteBigInteger)){
                result = false;
                break;
            }
        }
        assertTrue("test: ", result);
    }
}