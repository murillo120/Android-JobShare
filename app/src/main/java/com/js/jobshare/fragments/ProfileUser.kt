package com.js.jobshare.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.js.jobshare.R
import com.js.jobshare.activities.HomeActivity
import com.js.jobshare.models.User
import com.js.jobshare.viewmodels.ViewModelUser
import kotlinx.android.synthetic.main.fragment_profile_user.*


class profile_user : Fragment() {

    var currentUser: User? = null
    val viewModel = ViewModelUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("abacaxi", "veio aqui");

        (activity as HomeActivity).passData(object : DataThorughInferface {
            override fun setUserData(user: User?) {
                currentUser = user
                verifyData(currentUser)

            }

        })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_saveUser.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                executeSaveUserData()
            }

        })
    }

    fun verifyData(user: User?) {

        updateprofile_edit_name.setText(user?.name)
        updateprofile_edit_phone.setText(user?.phone)
        updateprofile_edit_idade.setText(user?.idade)
        updateprofile_edit_email.setText(user?.email)
        updateprofile_edit_cargo.setText(user?.cargo)
        updateprofile_edit_cep.setText(user?.adress?.cep)
        updateprofile_edit_adress.setText(user?.adress?.adress)
        updateprofile_edit_city.setText(user?.adress?.city)
        updateprofile_edit_state.setText(user?.adress?.state)

        if (updateprofile_edit_phone.text.toString().isEmpty()) {
            updateprofile_edit_phone.setError("Preencha com seu número")
        }
        if (updateprofile_edit_phone.text.toString().isEmpty()) {
            updateprofile_edit_phone.setError("Preencha com seu número")
        }
        if (updateprofile_edit_idade.text.toString().isEmpty()) {
            updateprofile_edit_idade.setError("Preencha com seu número")
        }
        if (updateprofile_edit_cargo.text.toString().isEmpty()) {
            updateprofile_edit_cargo.setError("Preencha com seu número")
        }
        if (updateprofile_edit_cep.text.toString().isEmpty()) {
            updateprofile_edit_cep.setError("Preencha com seu número")
        }
        if (updateprofile_edit_adress.text.toString().isEmpty()) {
            updateprofile_edit_adress.setError("Preencha com seu número")
        }
        if (updateprofile_edit_city.text.toString().isEmpty()) {
            updateprofile_edit_city.setError("Preencha com seu número")
        }
        if (updateprofile_edit_state.text.toString().isEmpty()) {
            updateprofile_edit_state.setError("Preencha com seu número")
        }

        currentUser?.name = updateprofile_edit_name.text.toString()
        currentUser?.phone = updateprofile_edit_phone.text.toString()
        currentUser?.idade = updateprofile_edit_idade.text.toString()
        currentUser?.cargo = updateprofile_edit_cargo.text.toString()
        currentUser?.adress?.cep = updateprofile_edit_cep.text.toString()
        currentUser?.adress?.city = updateprofile_edit_city.text.toString()
        currentUser?.adress?.state = updateprofile_edit_state.text.toString()
        currentUser?.adress?.adress = updateprofile_edit_adress.text.toString()

    }

    fun executeSaveUserData() {

        viewModel.updateUserDataOnFirebase(currentUser!!)
        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()


    }


}
