package com.example.currencyconverter

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.ConvertButton
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // React on button click
        ConvertButton.setOnClickListener {
            val et = findViewById<EditText>(R.id.cash)
            val inputText = et.text.toString()
            if (inputText.isNotBlank()) {
                // Convert currency to two decimal place
                val dollar = inputText.toDouble()
                val taka = ((dollar * 84.81) * 100.0).roundToInt() / 100.0

                // Show result
                val result = findViewById<TextView>(R.id.result)
                val formatted = "$taka taka"
                result.text = formatted
            }
        }
    }
}