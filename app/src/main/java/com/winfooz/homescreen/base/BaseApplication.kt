package com.winfooz.homescreen.base

import com.winfooz.homescreen.di.component.ApplicationComponent
import com.winfooz.homescreen.di.component.DaggerApplicationComponent
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): ApplicationComponent? {
        val component =
            DaggerApplicationComponent.builder().application(this)!!.build()
        component!!.inject(this)
        return component
    }
}