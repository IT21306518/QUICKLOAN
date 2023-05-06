package com.example.quickloan.ksactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quickloan.R
import com.example.quickloan.ksmodel.KsLoneModel
import com.google.firebase.database.FirebaseDatabase

class LoneDetailsActivity : AppCompatActivity() {
    private lateinit var tvLonId: TextView
    private lateinit var tvfName: TextView
    private lateinit var tvNic: TextView
    private lateinit var tvMobile: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAddres: TextView
    private lateinit var tvHmuch: TextView
    private lateinit var tvHlong: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lone_details)

        initView()
        setValuesToViews()

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("lonId").toString(),
                intent.getStringExtra("fName").toString()

            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("lonId").toString()
            )
        }

    }

    private fun initView() {
        tvLonId = findViewById(R.id.tvLonId)
        tvfName = findViewById(R.id.tvFullName)
        tvNic = findViewById(R.id.tvNIC)
        tvMobile = findViewById(R.id.tvMobile)
        tvEmail = findViewById(R.id.tvEmail)
        tvAddres = findViewById(R.id.tvAddress)
        tvHmuch = findViewById(R.id.tvHowMuch)
        tvHlong = findViewById(R.id.tvHowLong)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setValuesToViews() {
        tvLonId.text = intent.getStringExtra("lonId")
        tvfName.text = intent.getStringExtra("fname")
        tvNic.text = intent.getStringExtra("nno")
        tvMobile.text = intent.getStringExtra("mno")
        tvEmail.text = intent.getStringExtra("emails")
        tvAddres.text = intent.getStringExtra("address")
        tvHmuch.text = intent.getStringExtra("hmuch")
        tvHlong.text = intent.getStringExtra("hlong")

    }
    private fun deleteRecord(
        id: String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("Loans").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "User data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Ks_fetchingActivity2::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }


    private fun openUpdateDialog(
        lonId: String,
        fName: String
    ){
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.ksupdate,null)

        mDialog.setView(mDialogView)

        val etLonName = mDialogView.findViewById<EditText>(R.id.etLonName)
        val etNic = mDialogView.findViewById<EditText>(R.id.etNIC)
        val etMobile = mDialogView.findViewById<EditText>(R.id.etMobile)
        val etEmail = mDialogView.findViewById<EditText>(R.id.etEmail)
        val etAdders = mDialogView.findViewById<EditText>(R.id.etAddress)
        val etHmuch = mDialogView.findViewById<EditText>(R.id.etHmuch)
        val etHlong = mDialogView.findViewById<EditText>(R.id.etHlong)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)


        etLonName.setText( intent.getStringExtra("fname").toString())
        etNic.setText( intent.getStringExtra("nno").toString())
        etMobile.setText( intent.getStringExtra("mno").toString())
        etEmail.setText( intent.getStringExtra("emails").toString())
        etAdders.setText( intent.getStringExtra("address").toString())
        etHmuch.setText( intent.getStringExtra("hmuch").toString())
        etHlong.setText( intent.getStringExtra("hlong").toString())

        mDialog.setTitle("Updating $fName Record")

        val alertDialog = mDialog.create()
        alertDialog.show()


        btnUpdateData.setOnClickListener {
            updateLoanData(
                lonId,
                etLonName.text.toString(),
                etNic.text.toString(),
                etMobile.text.toString(),
                etEmail.text.toString(),
                etAdders.text.toString(),
                etHmuch.text.toString(),
                etHlong.text.toString()

            )
            Toast.makeText(applicationContext, "Loan Data Update", Toast.LENGTH_LONG).show()
//we are setting updated data to our textviews
            tvfName.text = etLonName.text.toString()
            tvNic.text = etNic.text.toString()
            tvMobile.text = etMobile.text.toString()
            tvEmail.text = etEmail.text.toString()
            tvAddres.text =  etAdders.text.toString()

            alertDialog.dismiss()

        }

    }

    private fun updateLoanData(
        id:String,
        name:String,
        nic:String,
        mobile:String,
        email:String,
        address:String,
        Hmuch:String,
        Hlong:String

    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("Loans").child(id)
        val loanInfo = KsLoneModel(id, name, nic, mobile, email, address, Hmuch, Hlong)
        dbRef.setValue(loanInfo)
    }
}
