package com.winfooz.homescreen.di.module

import com.google.gson.GsonBuilder
import com.winfooz.homescreen.data.remote.FeedsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {
     val BASE_URL = "https://d1f65f2f-9b42-4410-b6c8-ff6a2d6db909.mock.pstmn.io/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): FeedsRepository {
        return retrofit.create(FeedsRepository::class.java)
    }
}