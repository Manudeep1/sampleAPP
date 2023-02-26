package com.example.sampletest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback


class PostFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        val body = arguments?.getString("body")
        val id = arguments?.getInt("id")
        val title = arguments?.getInt("title")
        val tvId = view.findViewById<TextView>(R.id.tvId)
        val tvTitle = view.findViewById<TextView>(R.id.tvTile)
        val tvBody = view.findViewById<TextView>(R.id.tvBody)

        //setting up the ui
        tvId.text = id.toString()
        tvBody.text = body
        tvTitle.text = title.toString()



        //setting when user click the back button
        val callback = object :OnBackPressedCallback(true)
        {
            override fun handleOnBackPressed() {
                val i = Intent( activity ,MainActivity::class.java)
                activity?.startActivity(i)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

        return view


    }



}