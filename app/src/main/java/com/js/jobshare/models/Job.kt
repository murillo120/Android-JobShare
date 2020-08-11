package com.js.jobshare.models

class Job(
    var description: String = "",
    var nivel: String = "",
    var salario: Double = 0.0,
    var title: String = "",
    var companyImg: String = "",
    var companyName: String = ""
)
{
    override fun toString(): String {
        return "desc:${description} | nivel:$nivel | salario:$salario | title:$title | companyImg:$companyImg | companyName:$companyName"
    }
}