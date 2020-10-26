package com.js.jobshare.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.js.jobshare.R
import com.js.jobshare.viewmodels.ViewModelUser
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity() {

    private val context = this
    private val viewmodel = ViewModelUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        val window = this.window

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        register_progress.visibility = View.GONE

        viewmodel.register_key.observe(this, object : Observer<Boolean> {
            override fun onChanged(t: Boolean?) {
                if (t!!) {
                    register_progress.visibility = View.GONE

                    Toast.makeText(
                        context,
                        "Registrado com sucesso, execute o login!",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(context, LoginActivity::class.java)

                    startActivity(intent)
                    finish()
                } else {
                    register_progress.visibility = View.GONE
                    Toast.makeText(
                        context,
                        "Ooops! ${viewmodel.exception} ",
                        Toast.LENGTH_SHORT
                    ).show()


                }
            }
        })

        btn_register.setOnClickListener {

            viewmodel.registerJob()
//
//            register_progress.visibility = View.VISIBLE
//
//            val user = get<User>()
//            user.name = edit_reg_name.text.toString()
//            user.email = edit_reg_userEmail.text.toString()
//            user.password = edit_reg_PassWord.text.toString()
//
//            if (userType.isChecked) {
//                user.type = "employee"
//            } else {
//                user.type = "company"
//            }
//
//            viewmodel.executeRegisterOnApplication(user)
//
//
        }
    }
}