package com.winfooz.homescreen.ui.main

import com.winfooz.homescreen.ui.fragments.home.HomeFragment
import com.winfooz.homescreen.ui.fragments.news.NewsFragment
import com.winfooz.homescreen.ui.fragments.offer.OfferFragments
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment?

    @ContributesAndroidInjector
    abstract fun provideNewsFragment(): NewsFragment?

    @ContributesAndroidInjector
    abstract fun provideOfferFragment(): OfferFragments?
}