package com.example.currencyconverter

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun updateResult(v: View?) {
        val et = findViewById<EditText>(R.id.cash)
        val inputText = et.text.toString()
        if (!inputText.matches("")) {
            // Convert currency to two decimal place
            val dollar = inputText.toDouble()
            val taka = Math.round(dollar * 84.81 * 100).toDouble() / 100

            // Show result
            val result = findViewById<TextView>(R.id.result)
            val formatted = "$taka taka"
            result.text = formatted
        }
    }
}