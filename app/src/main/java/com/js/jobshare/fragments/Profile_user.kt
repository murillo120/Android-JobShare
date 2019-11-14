package com.js.jobshare.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.js.jobshare.R
import com.js.jobshare.activities.Home_activity
import com.js.jobshare.models.User
import kotlinx.android.synthetic.main.fragment_profile_user.*


class profile_user : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as Home_activity).passData(object : DataThorughInferface{
            override fun setUserData(user: User?) {

                updateprofile_edit_name.setText(user?.name)
                updateprofile_edit_phone.setText(user?.phone)
                if (updateprofile_edit_phone.text.toString().isEmpty()){
                    updateprofile_edit_phone.setError("")
                }

                updateprofile_edit_idade.setText(user?.idade)
                updateprofile_edit_email.setText(user?.email)
                updateprofile_edit_cargo.setText(user?.cargo)
                updateprofile_edit_cep.setText(user?.adress?.cep)
                updateprofile_edit_adress.setText(user?.adress?.adress)
                updateprofile_edit_city.setText(user?.adress?.city)
                updateprofile_edit_state.setText(user?.adress?.state)

            }

        })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile_user, container, false)
    }
}
