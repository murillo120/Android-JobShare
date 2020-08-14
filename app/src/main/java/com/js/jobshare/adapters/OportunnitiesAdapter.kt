package com.js.jobshare.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.js.jobshare.R
import com.js.jobshare.models.Job
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cel_job_post.view.*

class OportunnitiesAdapter(val oportunnitiesList: ArrayList<Job>, val context: Context) : RecyclerView.Adapter<OportunnitiesVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OportunnitiesVH {

        val view = LayoutInflater.from(context).inflate(R.layout.cel_job_post, parent, false)

        return OportunnitiesVH(view)
    }

    override fun getItemCount(): Int {

        return oportunnitiesList.size
    }

    override fun onBindViewHolder(holder: OportunnitiesVH, position: Int) {

        val jobItem = oportunnitiesList[position]

        Picasso.get().load(jobItem.companyImg).into(holder.companyImg)
        holder.companyName.text = jobItem.companyName
        holder.oportunnityTitle.text = jobItem.title
        holder.oportunnitySalary.text = "R$${jobItem.salario.toString()}"
        holder.oportunnityDescription.text = jobItem.description
        holder.oportunnityLevel.text = jobItem.nivel
    }
}

class OportunnitiesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val companyImg = itemView.companyImg
    val companyName = itemView.companyName
    val oportunnityTitle = itemView.oportunnityTitle
    val oportunnitySalary = itemView.oportunnitySalary
    val oportunnityDescription = itemView.oportunnityDesc
    val oportunnityLevel = itemView.oportunnityLevel


}