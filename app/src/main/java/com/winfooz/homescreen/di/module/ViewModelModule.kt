package com.winfooz.homescreen.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.winfooz.homescreen.di.utils.ViewModelKey
import com.winfooz.homescreen.ui.fragments.home.HomeViewModel
import com.winfooz.homescreen.ui.fragments.news.NewsViewModel
import com.winfooz.homescreen.ui.fragments.offer.OffersViewModel
import com.winfooz.homescreen.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindStoriesViewModel(storiesViewModel: HomeViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(OffersViewModel::class)
    abstract fun bindOffersViewModel(offersViewModel: OffersViewModel?): ViewModel?

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?
}