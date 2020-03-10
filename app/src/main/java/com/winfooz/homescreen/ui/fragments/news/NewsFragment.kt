package com.winfooz.homescreen.ui.fragments.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.winfooz.homescreen.R
import com.winfooz.homescreen.base.BaseFragment


class NewsFragment : BaseFragment() {
    override fun layoutRes(): Int {
        TODO("Not yet implemented")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


}
