package com.js.jobshare.models

class User(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var cargo: String = "",
    var idade: String = "",
    var phone: String = "",
    var adress: Adress? = null
) {

    override fun toString(): String {
        return "${name} $email"
    }


}