package com.js.jobshare.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.js.jobshare.R
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_pessoal_lermais.text = "ver mais"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)










//        if (test.maxLines >= 4) {
//            tv_pessoal_lermais.setOnClickListener {
//                Log.d("abacaxi", "joga esse rabetao")
//                Log.d("abacaxi", test.maxLines.toString())
//                Log.d("abacaxi", test.lineCount.toString())
//                if (test.maxLines <= 4) {
//                    test.setLines(test.lineCount)
//
//                    tv_pessoal_lermais.text = "ler menos"
//                } else {
//                    test.setLines(4)
//                    tv_pessoal_lermais.text = "ler mais"
//                    test.text = "${test.text}..."
//                }
//            }
//        }
    }
}
