package com.winfooz.homescreen.di.module

import com.winfooz.homescreen.ui.activities.HomeActivity
import com.winfooz.homescreen.ui.main.MainFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun bindMainActivity(): HomeActivity?
}