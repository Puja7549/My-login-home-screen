package com.example.myloginhomescreen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("SF_LOGIN", 0)
        val editor = sharedPreferences.edit()

        //button Click
        btnSignout.setOnClickListener {
            //get values from input field

            //open login/dashboard
            editor.putBoolean("LOGIN", false)
            editor.commit()

            val intent = Intent(this, SplahActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "successfully Signout", Toast.LENGTH_SHORT).show()
        }


    }
}


