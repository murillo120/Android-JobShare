package com.js.jobshare.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.js.jobshare.R
import com.js.jobshare.appModule
import com.js.jobshare.modelzModule
import com.js.jobshare.viewmodels.ViewModelMain
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.startKoin

class Splash_Acitivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        startKoin {
            androidContext(this@Splash_Acitivty)
            modules(listOf(appModule, modelzModule))
        }

        val viewmodel = getViewModel<ViewModelMain>()

        val handler = Handler()

        handler.postDelayed(object : Runnable {
            override fun run() {

                val intent: Intent?

                val sharedPreference = getSharedPreferences("JobShare_id", Context.MODE_PRIVATE)
                val savedUser = sharedPreference.getString("username", null);
                val savedPass = sharedPreference.getString("password", null);

                viewmodel.login_key.observe(this@Splash_Acitivty, Observer<Boolean> { works ->
                    if (works) {

                        val loggedintent: Intent?

                        loggedintent = Intent(applicationContext, Home_activity::class.java)
                        loggedintent.putExtra("userdata", savedUser)

                        startActivity(loggedintent)
                        finish()
                    }
                })

                if (!savedUser.isNullOrBlank() && !savedPass.isNullOrBlank()) {

                    viewmodel.executeLoginToHome(savedUser, savedPass)

                    return
                } else {
                    Log.d("abacaxi", "no infos on shared Prefs")
                    intent = Intent(applicationContext, Login_Activity::class.java)
                }

                startActivity(intent)
                finish()
            }

        }, 2000)
    }
}