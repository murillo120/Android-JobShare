package com.js.jobshare.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.js.jobshare.models.Job
import com.js.jobshare.models.User

class ViewModelUser : ViewModel() {

    var user = MutableLiveData<FirebaseUser>()
    val jobtest = MutableLiveData<ArrayList<Job>?>()
    val login_key = MutableLiveData<Boolean>()
    val register_key = MutableLiveData<Boolean>()
    val update_key = MutableLiveData<Boolean>()
    val authentication = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance().getReference("root")

    var exception: String? = null


    fun executeLoginToHome(email: String, password: String) {

        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                user.value = authentication.currentUser
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


    fun registerJob() {

        val job = Job()

        job.companyImg = "https://www.seebmacae.com.br/tim.php?src=uploads/images/2018/06/caso-santander-mostra-que-bancos-tem-mais-vantagens-no-brasil-1528375565.jpg&w=1600&h=800"
        job.companyName = "Banco Santander"
        job.description = "Atuar Nas Rotinas Das Áreas Administrativa e Financeira Com • Fornecedores: pagamento/ recebimentos • Fluxo de Caixa; • Operações de câmbio."
        job.title = "Analista Financeiro III"
        job.salario = 6000.0
        job.nivel = "Senior"

        database.child("jobs").push().setValue(job)

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

    fun updateUserDataOnFirebase(user: User) {

        val query: Query

        val postValues = user.toMap(user)

        Log.d("abacaxi", user.key)

        query = database.child("users").child(user.key!!)

        query.updateChildren(postValues)

    }


}








