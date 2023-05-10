package com.example.quickloan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class activity_nv_signup : AppCompatActivity() {

    private lateinit var etPass: EditText
    private lateinit var etEmail: EditText
    private lateinit var etConfirmPass: EditText
    private lateinit var btnSignup: Button
    private lateinit var tvSigninText: TextView
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nv_signup)

        etEmail = findViewById(R.id.signup_email)
        etPass = findViewById(R.id.signup_password)
        etConfirmPass = findViewById(R.id.signup_confirm)
        btnSignup = findViewById(R.id.signup_button)
        tvSigninText = findViewById(R.id.loginRedirectText)

        firebaseAuth = FirebaseAuth.getInstance()

        btnSignup.setOnClickListener{
            val email = etEmail.text.toString().trim()
            val password = etPass.text.toString().trim()
            val confirmPassword = etConfirmPass.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email is required"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPass.error = "Password is required"
                etPass.requestFocus()
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                etConfirmPass.error = "Confirm password is required"
                etConfirmPass.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                if (it.isSuccessful){
                    val intent = Intent(this, activity_nv_signin::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        tvSigninText.setOnClickListener {
            val loginIntent = Intent(this, activity_nv_signin::class.java)
            startActivity(loginIntent)
            finish()
        }
    }
}
