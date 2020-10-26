package com.js.jobshare.extensions

import java.text.DecimalFormat
import java.util.*

fun Double.toBrazilianCurrency(): String {
    val currency = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))

    return currency.format(this).replace("R$", "R$ ")
}