package com.example.quickloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ks_applyloan1 : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var middleName: EditText
    private lateinit var lastName: EditText
    private lateinit var nicNo: EditText
    private lateinit var birthDate: EditText
    private lateinit var email: EditText
    private lateinit var btnNext: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ks_applyloan1)

        firstName = findViewById(R.id.first_name_c2)
        middleName = findViewById(R.id.middle_name_d2)
        lastName = findViewById(R.id.last_name_e2)
        nicNo = findViewById(R.id.nic_no_f2)
        birthDate = findViewById(R.id.birth_date_g2)
        email = findViewById(R.id.email_h2)
        btnNext = findViewById(R.id.next_a)

        dbRef = FirebaseDatabase.getInstance().getReference("Loans")

        btnNext.setOnClickListener {
            saveLoanData()
        }
    }
    private fun saveLoanData() {

        //getting values
        val fName = firstName.text.toString()
        val mName = middleName.text.toString()
        val lName = lastName.text.toString()
        val nic = nicNo.text.toString()
        val bDate = birthDate.text.toString()
        val emails = email.text.toString()

        //validation
        if (fName.isEmpty()){
            firstName.error = "plese enter first name"
        }
        if (mName.isEmpty()){
            middleName.error = "plese enter middle name"
        }
        if (lName.isEmpty()){
            lastName.error = "plese enter last name"
        }
        if (nic.isEmpty()){
            nicNo.error = "plese enter nic"
        }
        if (bDate.isEmpty()){
            birthDate.error = "plese enter birth date"
        }
        if (emails.isEmpty()){
            email.error = "plese enter email"
        }

        val loneId = dbRef.push().key!!

        val Lone = KsLoneModel(loneId, fName, mName, lName, nic, bDate, emails)

        dbRef.child(loneId).setValue(Lone)
            .addOnCompleteListener{
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{ err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}