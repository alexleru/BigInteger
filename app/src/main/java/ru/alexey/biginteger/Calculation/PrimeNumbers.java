package ru.alexey.biginteger.Calculation;

import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeNumbers {


    private ArrayList<BigInteger> bigIntegerArrayList;
    private BigInteger checkNumber;
    private final BigInteger BigTWO = new BigInteger("2");
    public PrimeNumbers(ArrayList<BigInteger> bigIntegerArrayList) {
        this.bigIntegerArrayList = bigIntegerArrayList;
    }


    public ArrayList<BigInteger> getBigIntegerArrayList() {
        return bigIntegerArrayList;
    }

    public void loop(){
        checkNumber = max(bigIntegerArrayList);
        for(int i = 0; i < 1000; i++){
            System.out.print(i + " ");
            checkNumber = checkNumber.add(BigTWO);
            checkNumber(bigIntegerArrayList, checkNumber);
        }
    }

    //нахождение простого числа
    private void checkNumber(ArrayList<BigInteger> bigIntegerArrayList, BigInteger checkNumber){
        BigInteger maxPotentialDivider = (checkNumber.subtract(BigInteger.ONE)).divide(BigTWO);
        for (BigInteger bigInteger : bigIntegerArrayList){
            int compare = bigInteger.compareTo(maxPotentialDivider);
            if(compare > 0 ){
                this.bigIntegerArrayList.add(checkNumber);
                System.out.println("Prime:   " + checkNumber);
                break;
            }
            if((checkNumber.mod(bigInteger)).equals(BigInteger.ZERO)){
                System.out.println("Complex: " + checkNumber + " " + bigInteger );
                break;
            }
        }
    }

    //определение максимального числа
    private BigInteger max(ArrayList<BigInteger> bigIntegerArrayList){
        BigInteger max = new BigInteger("0");
        for (BigInteger bigInteger : bigIntegerArrayList){
            max = max.max(bigInteger);
        }
        return max;
    }
}
