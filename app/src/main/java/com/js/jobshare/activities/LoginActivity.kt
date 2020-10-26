package com.js.jobshare.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.js.jobshare.R
import com.js.jobshare.viewmodels.ViewModelUser
import kotlinx.android.synthetic.main.login_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    val context = this
    val viewmodel by viewModel<ViewModelUser>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        setView()
        initViews()
        loadViewModel()
    }

    private fun initViews() {
        login_progressbar.visibility = View.GONE

        btn_login.setOnClickListener {
            login_progressbar.visibility = View.VISIBLE
            executeLogin()
        }

        flat_register.setOnClickListener {

            val intent = Intent(context, RegisterActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun executeLogin() {
        val email = edit_reg_userEmail.text.toString()
        val password = edit_reg_PassWord.text.toString()

        if (email.isEmpty()) {
            edit_reg_userEmail.setError("preencha o Campo de E-mail corretamente")
            return
        }

        if (password.isEmpty()) {
            edit_reg_PassWord.setError("preencha o Campo de Senha Corretamente")
            return
        }

        viewmodel.executeLoginToHome(email, password)
    }

    private fun loadViewModel() {
        viewmodel.user.observe(this, object : Observer<FirebaseUser> {
            override fun onChanged(t: FirebaseUser?) {



                saveLoginDataOnSharedPrefs()
            }

        })
    }

    private fun saveLoginDataOnSharedPrefs() {
        val sharedPreference =  getSharedPreferences("JobShare_id",Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        val email = edit_reg_userEmail.text.toString()
        val password = edit_reg_PassWord.text.toString()

        editor.putString("username",email)
        editor.putString("password",password)
        editor.apply()
    }

    private fun setView() {
        val window = this.window

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

    }


}
