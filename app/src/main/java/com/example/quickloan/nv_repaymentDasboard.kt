package com.example.quickloan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class nv_repaymentDasboard : AppCompatActivity() {

    private lateinit var btnPayNow: Button
    private lateinit var tvViewAllPay:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_repayment_dasboard)

        btnPayNow=findViewById(R.id.btn_repayment)
        tvViewAllPay=findViewById(R.id.textdashboard)

        btnPayNow.setOnClickListener {
            val intent = Intent(this,nv_PaymentForm::class.java)
            startActivity(intent)
        }
        tvViewAllPay.setOnClickListener {
            val intent = Intent(this,nv_payments::class.java)
            startActivity(intent)
        }
    }
}