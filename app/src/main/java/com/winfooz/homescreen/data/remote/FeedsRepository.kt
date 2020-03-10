package com.winfooz.homescreen.data.remote

import com.winfooz.homescreen.data.model.News
import com.winfooz.homescreen.data.model.Offer
import com.winfooz.homescreen.data.model.Story
import io.reactivex.Single
import javax.inject.Inject

class FeedsRepository @Inject constructor(private val feedsApiService: FeedsApiService) {
    fun getStories(): Single<List<Story>?>? {
        return feedsApiService.getStories()
    }

    fun getNews(): Single<List<News>?>? {
        return feedsApiService.getNews()
    }

    fun getOffers(): Single<List<Offer>?>? {
        return feedsApiService.getOffers()
    }

}