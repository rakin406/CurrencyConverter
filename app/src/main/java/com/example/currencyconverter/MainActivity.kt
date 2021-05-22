package com.example.currencyconverter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.convertButton
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currencies = arrayOf("BDT", "Canadian Dollar", "Chinese Yuan", "Euro", "Indian Rupee",
            "Jamaican Dollar", "Japanese Yen", "USD")

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

        // React on button click
        convertButton.setOnClickListener {
            val originalCurrency = fromCurrency.selectedItem.toString()
            val convertedCurrency = toCurrency.selectedItem.toString()
            val et = findViewById<EditText>(R.id.input)
            val inputText = et.text.toString()

            if (inputText.isNotBlank()) {
                // Convert currency to two decimal place
                val amount = inputText.toDouble()

                // Don't change input value if both currencies are the same
                val convertedAmount: Double = if (originalCurrency == convertedCurrency) {
                    amount
                } else {
                    ((amount * getExchangeRate(originalCurrency, convertedCurrency)) * 100.0).roundToInt() / 100.0
                }

                // Show result
                val result = findViewById<TextView>(R.id.result)
                val formatted = "$convertedAmount $convertedCurrency"
                result.text = formatted
            }
        }
    }

    /*
     * Get exchange rate by checking the currencies
     */
    private fun getExchangeRate(originalCurrency: String, convertedCurrency: String): Double {
        // TODO: Manage all currencies and exchange rates
        return if (originalCurrency == "BDT") {
            when (convertedCurrency) {
                "Canadian Dollar" -> 0.014
                "Chinese Yuan" -> 0.076
                "Euro" -> 0.0097
                "Indian Rupee" -> 0.86
                "Jamaican Dollar" -> 1.76
                "Japanese Yen" -> 1.28
                "USD" -> 0.012
                else -> {
                    1.0
                }
            }
        } else if (originalCurrency == "Canadian Dollar") {
            when (convertedCurrency) {
                "BDT" -> 70.30
                "Chinese Yuan" -> 5.33
                "Euro" -> 0.68
                "Indian Rupee" -> 60.42
                "Jamaican Dollar" -> 124.01
                "Japanese Yen" -> 90.26
                "USD" -> 0.83
                else -> {
                    1.0
                }
            }
        } else if (originalCurrency == "USD") {
            when (convertedCurrency) {
                "BDT" -> 84.83
                "Canadian Dollar" -> 1.21
                "Chinese Yuan" -> 6.43
                "Euro" -> 0.82
                "Indian Rupee" -> 72.91
                "Jamaican Dollar" -> 149.65
                "Japanese Yen" -> 108.93
                else -> {
                    1.0
                }
            }
        } else if (originalCurrency == "BDT") {
            when (convertedCurrency) {
                "USD" -> 0.012
                else -> {
                    1.0
                }
            }
        } else {
            1.0
        }
    }
}