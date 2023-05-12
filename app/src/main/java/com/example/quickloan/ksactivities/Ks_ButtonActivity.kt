package com.example.quickloan.ksactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.quickloan.R

class Ks_ButtonActivity : AppCompatActivity() {

    private lateinit var btnApply: ImageView
    private lateinit var btnManege: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ks_button)

        btnApply = findViewById(R.id.paynowIMG)
        btnManege = findViewById(R.id.manageIMG)

        btnApply.setOnClickListener {
            navigateToNextActivity()


        }

        btnManege.setOnClickListener {
            navigateTonextActivity()
        }

    }

    private fun navigateToNextActivity() {
        val intent = Intent(this, ks_ApplyLoan::class.java)
        startActivity(intent)
    }

    private fun  navigateTonextActivity() {
        val intent = Intent(this, Ks_fetchingActivity2::class.java)
        startActivity(intent)
    }


}