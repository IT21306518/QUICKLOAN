package com.example.quickloan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var loanAmount: EditText
    private lateinit var annualInterestRate: EditText
    private lateinit var loanPeriod: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bu_calculator)

        loanAmount = findViewById(R.id.loan_amount_edit_text)
        annualInterestRate = findViewById(R.id.annual_interest_rate_edit_text)
        loanPeriod = findViewById(R.id.loan_period_edit_text)
        calculateButton = findViewById(R.id.calculate_button)
        resultTextView = findViewById(R.id.result_text_view)

        calculateButton.setOnClickListener { calculateLoanPayment() }
    }

    @SuppressLint("StringFormatInvalid")
    private fun calculateLoanPayment() {
        val principal = loanAmount.text.toString().toDouble()
        val annualRate = annualInterestRate.text.toString().toDouble()
        val loanYears = loanPeriod.text.toString().toDouble()

        val loanMonths = loanYears * 12
        val monthlyRate = annualRate / 12 / 100
        val monthlyPayment = principal * monthlyRate / (1 - (1 / Math.pow(1 + monthlyRate, loanMonths)))

        val formattedPayment = NumberFormat.getCurrencyInstance().format(monthlyPayment)

        resultTextView.text = getString(R.string.monthly_payment_result, formattedPayment)
    }
}
