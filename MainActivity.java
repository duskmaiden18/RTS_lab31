package com.example.lab1_vlada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class MainActivity extends AppCompatActivity {

    // Завдання: вирішіть проблему зациклення при великому значенні.
    private static final String VALIDATE_REGEX = "^((?!(0))[0-9]{1,5})$";
    private AwesomeValidation validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText endResult = findViewById(R.id.endResult);
        EditText input = findViewById(R.id.number);
        Button button = findViewById(R.id.button);

        validation = new AwesomeValidation(ValidationStyle.BASIC);
        validation.addValidation(this, R.id.number, VALIDATE_REGEX 
                R.string.validate);

        String result = factorize();
        endResult.setText(result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(),
                            "Everythong correct",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Wrong input",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String factorize() {
        String result = "";
        String text = input.getText().toString();

        if (text.isEmpty()){
            text = "0";
        }
        int n = Integer.parseInt(text);

        if (n <= 0) {
            result += n + " ";
            return result;
        }

        int square_root = (int) Math.ceil(Math.sqrt(n));

        if (square_root * square_root == n) {
            result += " " + square_root + ", " + square_root;
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
