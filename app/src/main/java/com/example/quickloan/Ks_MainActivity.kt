package com.example.quickloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class KsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ks_applyloan_a)
        setContentView(R.layout.ks_applyloan_b)

        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
    }
}