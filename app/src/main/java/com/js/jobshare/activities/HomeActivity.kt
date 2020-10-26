package com.js.jobshare.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.js.jobshare.R
import com.js.jobshare.adapters.PageAdapter
import com.js.jobshare.fragments.DataThorughInferface
import com.js.jobshare.viewmodels.ViewModelUser
import kotlinx.android.synthetic.main.home_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    val viewmodel by viewModel<ViewModelUser>()
    val context = this
    var userinfo: DataThorughInferface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        viewmodel.user.observe(this,
            Observer<FirebaseUser> { user ->
                home_username.text = getString(R.string.hello_user, user.displayName)



//                if (user?.adress == null) {
//
//                    AlertDialog.Builder(context)
//                        .setTitle("Importante!")
//                        .setMessage("Você precisa atualizar suas informações pessoais!")
//                        .setNeutralButton("atualizar", object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                home_view_pager.currentItem = 1
//                                userinfo?.setUserData(user)
//                            }
//                        })
//                        .show()
//                }
//
//                userinfo?.setUserData(user)
            })

        val window = this.window

        val pageAdapter = PageAdapter(supportFragmentManager)

        home_view_pager.adapter = pageAdapter

        home_tab_layout.setupWithViewPager(home_view_pager)
        home_tab_layout.getTabAt(0)?.setIcon(R.drawable.hammericon)
        home_tab_layout.getTabAt(1)?.setIcon(R.drawable.user)
        home_tab_layout.getTabAt(0)?.setText("Feed")
        home_tab_layout.getTabAt(1)?.setText("Profile")
        Log.d("abacaxi", home_tab_layout.tabCount.toString())

        home_logout_button.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            finish()

        }

        init()
    }

    fun init() {

        val userdata = intent.getStringExtra("userdata")
        Log.d("abacaxi", userdata)
    }

    fun passData(userData: DataThorughInferface) {

        this.userinfo = userData

    }

}