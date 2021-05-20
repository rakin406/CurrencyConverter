package com.example.currencyconverter

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.convertButton
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currencies = arrayOf("Dollar", "Taka")
        val fromCurrency: Spinner = findViewById(R.id.fromCurrency)
        val toCurrency: Spinner = findViewById(R.id.toCurrency)

        // Initializing an ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            currencies
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        fromCurrency.adapter = adapter
        toCurrency.adapter = adapter

        // Set default currencies
        fromCurrency.setSelection(0)    // Dollar
        toCurrency.setSelection(1)  // Taka
        var exchangeRate = 84.82
        var convertedCurrency = "Taka"

        fromCurrency.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
            }

            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }

        toCurrency.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                val currency = currencies[position]
                if (currency == "Dollar") {
                    exchangeRate = 0.012
                } else if (currency == "Taka") {
                    exchangeRate = 84.82
                }
                convertedCurrency = currency
            }

            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }

        // React on button click
        convertButton.setOnClickListener {
            val et = findViewById<EditText>(R.id.input)
            val inputText = et.text.toString()
            if (inputText.isNotBlank()) {
                // Convert currency to two decimal place
                val amount = inputText.toDouble()
                val convertedAmount = ((amount * exchangeRate) * 100.0).roundToInt() / 100.0

                // Show result
                val result = findViewById<TextView>(R.id.result)
                val formatted = "$convertedAmount $convertedCurrency"
                result.text = formatted
            }
        }
    }
}