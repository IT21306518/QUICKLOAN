package com.example.quickloan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ks_applyloan2 : AppCompatActivity() {

//    private lateinit var mobileNo: EditText
//    private lateinit var yProvince: EditText
//    private lateinit var yDistric: EditText
//    private lateinit var yCity: EditText
//    private lateinit var yAddress: EditText
//    private lateinit var liveThere: Spinner
//    private lateinit var btnBack2: Button
//    private lateinit var btnNext2: Button
//
//    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ks_applyloan2)

//        mobileNo = findViewById(R.id.mobile_no_2h2)
//        yProvince = findViewById(R.id.your_province_2c2)
//        yDistric = findViewById(R.id.your_distric_2d2)
//        yCity = findViewById(R.id.your_city_2e2)
//        yAddress = findViewById(R.id.your_address_2f2)
//        liveThere = findViewById(R.id.live_there_2g2)
//        btnBack2 = findViewById(R.id.Back_2a)
//        btnNext2 = findViewById(R.id.next_2a)
//
//        dbRef = FirebaseDatabase.getInstance().getReference("Loans")
//
//        btnNext2.setOnClickListener {
//            saveLoanData()
//
//            startActivity(Intent(this, ks_applyloan3::class.java))
//        }
//
//        btnBack2.setOnClickListener {
//
//            startActivity(Intent(this, ks_applyloan1::class.java))
//        }
//    }
//       private fun saveLoanData(){
//           //getting values
//           val mNO = mobileNo.text.toString()
//           val yProvi = yProvince.text.toString()
//           val yDist = yDistric.text.toString()
//           val city = yCity.text.toString()
//           val yAdd = yAddress.text.toString()
//           val lThere = liveThere.dropDownVerticalOffset.toString()
//
//           //validation
//           if (mNO.isEmpty()){
//               mobileNo.error = "plese enter mobile no"
//           }
//           if (yProvi.isEmpty()){
//               yProvince.error = "plese enter your province"
//           }
//           if (yDist.isEmpty()){
//               yDistric.error = "plese enter your distric"
//           }
//           if (city.isEmpty()){
//               yCity.error = "plese enter your city"
//           }
//           if (yAdd.isEmpty()){
//               yAddress.error = "plese enter your address"
//           }
//
//           val loneId = dbRef.push().key!!
//
//           val Lone = KsLoneModel(loneId, mNO, yProvi, yDist, city, yAdd, lThere)
//
//           dbRef.child(loneId).setValue(Lone)
//            .addOnCompleteListener{
//                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
//            }.addOnFailureListener{ err ->
//                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

       }



