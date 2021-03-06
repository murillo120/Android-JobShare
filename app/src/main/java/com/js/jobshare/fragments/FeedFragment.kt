package com.js.jobshare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.js.jobshare.R
import com.js.jobshare.adapters.OportunnitiesAdapter
import com.js.jobshare.models.Job
import com.js.jobshare.viewmodels.ViewModelUser
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    val viewmodel by viewModel<ViewModelUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jobsRecycler = jobsRecycler

        viewmodel.jobtest.observe(viewLifecycleOwner, object : Observer<ArrayList<Job>?> {
            override fun onChanged(t: ArrayList<Job>?) {

                val layoutManager = LinearLayoutManager(context)
                jobsRecycler.apply {
                    this.adapter = OportunnitiesAdapter(t!!,context)
                    this.layoutManager = LinearLayoutManager(context)
                }
            }

        });

        viewmodel.getJobFeed()

    }
}
