package com.js.jobshare.models

import java.util.*
import kotlin.collections.HashMap

class User(
    var key: String? = null,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var cargo: String = "",
    var idade: String = "",
    var phone: String = "",
    var type: String = "",
    var adress: Adress? = null
) {

    override fun toString(): String {
        return "${name} $email"
    }

    fun toMap(user:User) : HashMap<String, Any?>{

        val newMap = HashMap<String, Any?>()

        newMap["cargo"] = user.cargo
        newMap["email"] =user.email
        newMap["idade"]=  user.idade
        newMap["name"] = user.name
        newMap["password"]= user.password
        newMap["phone"] = user.phone
        newMap["adress"] = user.adress

        return newMap
    }


}