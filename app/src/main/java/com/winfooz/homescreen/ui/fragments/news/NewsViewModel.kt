package com.winfooz.homescreen.ui.fragments.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winfooz.homescreen.data.model.News
import com.winfooz.homescreen.data.remote.FeedsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val feedsRepository: FeedsRepository) :
    ViewModel() {
    private var disposable: CompositeDisposable?
    private val news = MutableLiveData<List<News>>()
    private val newsLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()
    fun getOffers(): LiveData<List<News>> {
        return news
    }

    fun getError(): LiveData<Boolean> {
        return newsLoadError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchNews() {
        loading.value = true
        disposable?.add(
            feedsRepository.getNews()!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<List<News?>?>() {
                    override fun onSuccess(value: List<News?>?) {
                        newsLoadError.value = false
                        news.value = value as List<News>?
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        newsLoadError.value = true
                        loading.value = false
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (disposable != null) {
            disposable!!.clear()
            disposable = null
        }
    }

    init {
        disposable = CompositeDisposable()
        fetchNews()
    }
}