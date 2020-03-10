package com.winfooz.homescreen.ui.fragments.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.winfooz.homescreen.R
import com.winfooz.homescreen.base.BaseFragment
import com.winfooz.homescreen.utils.ViewModelFactory


class HomeFragment : BaseFragment() {

    private var homeViewModel: HomeViewModel? = null
    override fun layoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_home, container, false)


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mViewModel = ViewModelProvider(this, ViewModelFactory(activity!!)).get(HomeViewModel::class)
//        homeViewModel= ViewModelProviders.of(activity!!).get(HomeViewModel::class)
    }

}
