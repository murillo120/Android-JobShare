package com.js.jobshare.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.js.jobshare.models.Job
import com.js.jobshare.models.User

class ViewModelMain : ViewModel() {

    var user = MutableLiveData<User>()
    val jobtest = MutableLiveData<ArrayList<Job>?>()
    val login_key = MutableLiveData<Boolean>()
    val register_key = MutableLiveData<Boolean>()
    val authentication = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance().getReference("root")

    var exception:String? = null


    fun executeLoginToHome(email: String, password: String) {

        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                login_key.value = true

                return@addOnCompleteListener
            }
            exception = task.exception?.message
            login_key.value = false

        }

    }

    fun executeRegisterOnApplication(user: User) {

        authentication.createUserWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener { task ->

            if (task.isSuccessful) {
                register_key.value = true

                database.child("users").push().setValue(user)

                return@addOnCompleteListener
            }
            exception = task.exception?.message
            Log.d("abacaxi", task.exception?.message)
            register_key.value = false

        }
    }

    fun getUserdata(userEmail:String){

        val query: Query

        query = database.child("users")
        
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                if (data.exists()){
                    val userr = data.children
                    userr.forEach {
                        if (it.getValue(User::class.java)?.email == userEmail){
                            user.value = it.getValue(User::class.java)
                            return@forEach
                        }
                    }

                }
            }

        })
    }

    fun getJobFeed() {
        val query: Query

        query = database.child("jobs")

        query.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {

                var list = ArrayList<Job>()

                p0.children.forEach {
                    Log.d("abacaxi", "onDataChange: ${it.getValue(Job::class.java)}")

                    list.add(it.getValue(Job::class.java)!!)

                }

                jobtest.value = list
            }

        })


    }


}








