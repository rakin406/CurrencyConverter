package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateResult(View v) {
        EditText et = findViewById(R.id.cash);
        String inputText = et.getText().toString();

        if (!inputText.matches("")) {
            // Convert currency to two decimal place
            double dollar = Double.parseDouble(inputText);
            double taka = (double) Math.round((dollar * 84.81) * 100) / 100;

            // Show result
            TextView result = findViewById(R.id.result);
            String formatted = taka + " taka";
            result.setText(formatted);
        }
    }
}
