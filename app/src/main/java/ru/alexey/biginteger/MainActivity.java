package ru.alexey.biginteger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;

import ru.alexey.biginteger.Calculation.PrimeNumbers;
import ru.alexey.biginteger.Controllers.ControllerDataBase;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ScrollView scrollView;
    ArrayList<BigInteger> bigIntegers;
    Thread thread;
    ControllerDataBase controllerDataBase;

    PrimeNumbers primeNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView3);
        scrollView = findViewById(R.id.scroll);

        bigIntegers = new ArrayList<>();
        BigInteger bigInteger = new BigInteger("3");
        bigIntegers.add(bigInteger);
        primeNumbers = new PrimeNumbers(bigIntegers);

        controllerDataBase = new ControllerDataBase();

    }


    public void onClickGetData(View view) {
        bigIntegers = null;
        textView.setText(null);
        textView.append("get Data\n");
        bigIntegers = controllerDataBase.getAllBigIntegers();
        for (BigInteger bigInteger : bigIntegers){ // DRY 2
             textView.append("\n" + bigInteger.toString());
        }
    }

    public void onClickSendData(View view)
    {
        textView.append("send Data\n");
        if(thread == null || !thread.isAlive()){
            bigIntegers = primeNumbers.getBigIntegerArrayList();
            for (BigInteger big : bigIntegers) {
                textView.append("\n" + big.toString());

            }
            scrollDown();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    controllerDataBase.insertBig(bigIntegers);
                }
            }).start();

        }else {
            textView.append("waiting");
        }
    }

    public void onClickCalculate(View view) {

        //вынести в отедльный класс
        if(thread == null || !thread.isAlive()) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    primeNumbers.loop();
                }
            });
            thread.start();
        }else {
            textView.setTextColor(Color.RED);
            textView.append("waiting gor calculate");
            textView.setTextColor(Color.BLACK);
        }
    }

    public void onClickStop(View view) {

    }

    private void scrollDown(){
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(scrollView.FOCUS_DOWN);
            }
        });
    }
}
