package com.example.lab1_vlada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText input = findViewById(R.id.number);
        EditText endResult = findViewById(R.id.endResult);

        final int number = Integer.parseInt(input.getText().toString());
        final String result = factorize(number);

        endResult.setText(result);
    }

    public String factorize(int n) {
        String result = "";

        if (n <= 0) {
            result += n + " ";
            return result;
        }

        if (n % 2 == 0) {
            //result += " "+  n / 2.0 + ", " + 2;
            result += "Число має бути простим";
            return result;
        }

        int square_root = (int) Math.ceil(Math.sqrt(n));

        if (square_root * square_root == n) {
            System.out.print("[" + square_root + "," + square_root + "]");
            result += " "+ square_root + ", " + square_root;
            return result;
        }

        int b;

        while (true) {
            int b1 = square_root * square_root - n;
            b = (int) (Math.sqrt(b1));

            if (b * b == b1)
                break;
            else
                square_root += 1;
        }
        result += " " + (square_root - b) + "," + (square_root + b) + " ";
        return result;
    }
}
