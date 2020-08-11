package com.js.jobshare.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.js.jobshare.R
import com.js.jobshare.models.Job
import com.js.jobshare.viewmodels.ViewModelMain
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    val viewmodel by viewModel<ViewModelMain>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel.jobtest.observe(this, object : Observer<ArrayList<Job>?> {
            override fun onChanged(t: ArrayList<Job>?) {
                Log.d("abacaxi", "onChanged: ${t!![0].toString()} ")
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewmodel.getJobFeed()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
