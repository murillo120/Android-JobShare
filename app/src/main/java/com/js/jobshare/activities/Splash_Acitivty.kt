package com.js.jobshare.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.js.jobshare.R

class Splash_Acitivty : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        var handler = Handler()

        handler.postDelayed(object : Runnable {
            override fun run() {

                var intent = Intent(applicationContext, Login_Activity::class.java)
                startActivity(intent)
                finish()
            }

        },2000)
    }
}