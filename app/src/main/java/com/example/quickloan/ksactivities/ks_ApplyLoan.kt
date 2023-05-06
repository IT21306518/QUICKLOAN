package com.example.quickloan.ksactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.quickloan.ksmodel.KsLoneModel
import com.example.quickloan.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ks_ApplyLoan : AppCompatActivity() {

    //Create Variables
    private lateinit var fullName: EditText
    private lateinit var nicNo: EditText
    private lateinit var mobileNo: EditText
    private lateinit var email: EditText
    private lateinit var uAddress: EditText
    private lateinit var howMuch: Spinner
    private lateinit var howLong: Spinner
    private lateinit var btnsubmit: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ks_apply_loan)

        fullName = findViewById(R.id.full_Name_2)
        nicNo = findViewById(R.id.nic_No_2)
        mobileNo = findViewById(R.id.mobile_No_2)
        email = findViewById(R.id.email_2)
        uAddress = findViewById(R.id.your_Address_2)
        howMuch = findViewById(R.id.how_much_2)
        howLong = findViewById(R.id.how_long_2)
        btnsubmit = findViewById(R.id.submit_a)

        dbRef = FirebaseDatabase.getInstance().getReference("Loans")

        btnsubmit.setOnClickListener {
           saveLoanData()

        }

    }




    //getting values
    private fun saveLoanData(){
        val fName = fullName.text.toString()
        val nNo = nicNo.text.toString()
        val mNo = mobileNo.text.toString()
        val emails = email.text.toString()
        val address = uAddress.text.toString()
        val hMuch = howMuch.selectedItem.toString()
        val hLong = howLong.selectedItem.toString()



        //validation and check all field fill or not
        if (fName.isEmpty()){
            fullName.error = "plese enter full name"
        }
        if (nNo.isEmpty()){
            nicNo.error = "plese enter Nic"
        }
        if (mNo.isEmpty()){
            mobileNo.error = "plese enter mobile no"
        }
        if (emails.isEmpty()){
            email.error = "plese enter email"
        }
        if (address.isEmpty()){
            uAddress.error = "plese enter address"
        }


        //Generate a new unique key and returns a DatabaseReference
        val loneId = dbRef.push().key!!


        //pass the data constructor
        val Lone = KsLoneModel(loneId, fName, nNo, mNo, emails, address, hMuch, hLong)

        dbRef.child(loneId).setValue(Lone)
            .addOnCompleteListener{
                Toast.makeText(this, "Lone details submit successfully", Toast.LENGTH_LONG).show()


                //if Data successfully insertsd ofter clear all fields default
                fullName.text.clear()
                nicNo.text.clear()
                mobileNo.text.clear()
                email.text.clear()
                uAddress.text.clear()
                howMuch.setSelection(0)
                howLong.setSelection(0)

            }.addOnFailureListener{ err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}