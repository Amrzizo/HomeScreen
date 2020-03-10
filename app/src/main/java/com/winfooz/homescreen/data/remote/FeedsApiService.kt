package com.winfooz.homescreen.data.remote

import com.winfooz.homescreen.data.model.News
import com.winfooz.homescreen.data.model.Offer
import com.winfooz.homescreen.data.model.Story
import io.reactivex.Single
import retrofit2.http.GET

interface FeedsApiService {
    @GET("offers")
    fun getStories(): Single<List<Story>?>?

    @GET("news")
    fun getNews(): Single<List<News>?>?

    @GET("stories")
    fun getOffers(): Single<List<Offer>?>?

}