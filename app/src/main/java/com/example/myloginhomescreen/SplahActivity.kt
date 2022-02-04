package com.example.myloginhomescreen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class SplahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SF_LOGIN", 0)
        val editor = sharedPreferences?.edit()

        if (sharedPreferences.getBoolean("LOGIN", false)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        //button Click
        btnLogin.setOnClickListener {
            //get values from input field
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            //validation
            if (username.isEmpty())//return true if user name is empty
            {
                etUsername.error = "Enter username"
                etUsername.requestFocus() //to get the field selecting(show cursor)
            } else if (password.isEmpty()) {
                etPassword.error = "Enter password" //error message to show
                etPassword.requestFocus()
            } else {
//validation is successful


                if (username.equals("Puja", true)) {
                    //user name is ok

                    if (password.equals("A1234b")) {
                        //password is ok

                        //open home/dashboard
                        editor?.putBoolean("LOGIN", true)
                        editor?.commit()

                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "password is A1234b", Toast.LENGTH_SHORT).show()

                    }

                } else {
                    Toast.makeText(this, "user name is puja", Toast.LENGTH_SHORT).show()


                }


            }

        }
    }
}

