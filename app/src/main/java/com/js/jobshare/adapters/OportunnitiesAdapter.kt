package com.js.jobshare.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.js.jobshare.models.Job

class OportunnitiesAdapter(val oportunnitiesList: ArrayList<Job>, val context: Context) : RecyclerView.Adapter<OportunnitiesVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OportunnitiesVH {

        return OportunnitiesVH(View(context))
    }

    override fun getItemCount(): Int {

        return oportunnitiesList.size
    }

    override fun onBindViewHolder(holder: OportunnitiesVH, position: Int) {
    }
}

class OportunnitiesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}