package com.winfooz.homescreen.ui.fragments.home

import androidx.databinding.ObservableField
import com.winfooz.homescreen.R
import com.winfooz.homescreen.data.model.News
import com.winfooz.homescreen.data.model.Story
import com.winfooz.homescreen.ui.base.BaseItemViewModel

class NewsItemViewModel(val news: News) : BaseItemViewModel() {
    var newsImg = ObservableField("")
    var newsTitle = ObservableField("")
    var newsDescription = ObservableField("")

    override fun getLayoutId(): Int {
        return R.layout.news_item_layout
    }

    init {
        newsImg.set(news.image)
        newsTitle.set(news.title)
        newsDescription.set(news.description)
    }
}