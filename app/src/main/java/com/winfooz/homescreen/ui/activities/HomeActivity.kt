package com.winfooz.homescreen.ui.activities

import android.os.Bundle
import com.winfooz.homescreen.R
import com.winfooz.homescreen.base.BaseActivity
import com.winfooz.homescreen.ui.fragments.home.HomeFragment

class HomeActivity : BaseActivity() {

    private var homeFragment: HomeFragment? = null

    override fun layoutRes(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            homeFragment =
                HomeFragment()
        }
        getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, homeFragment!!)
            .commit()
    }
}
