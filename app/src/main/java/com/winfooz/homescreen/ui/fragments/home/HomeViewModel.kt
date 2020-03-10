package com.winfooz.homescreen.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winfooz.homescreen.data.model.News
import com.winfooz.homescreen.data.model.Offer
import com.winfooz.homescreen.data.model.Story
import com.winfooz.homescreen.data.remote.FeedsRepository
import com.winfooz.homescreen.ui.base.BaseAdapter
import com.winfooz.homescreen.ui.interfaces.ViewHolderInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val feedsRepository: FeedsRepository) :
    ViewModel(), ViewHolderInterface {
    private var disposable: CompositeDisposable?
    private val stories = MutableLiveData<List<Story>>()
    private val storiesLoadError = MutableLiveData<Boolean>()
    private val storiesLoading = MutableLiveData<Boolean>()
    private val news = MutableLiveData<List<News>>()
    private val newsLoadError = MutableLiveData<Boolean>()
    private val newsLoading = MutableLiveData<Boolean>()
    private val offers = MutableLiveData<List<Offer>>()
    private val offersLoadError = MutableLiveData<Boolean>()
    private val offersLoading = MutableLiveData<Boolean>()

    private var storiesList: ArrayList<StoryItemViewModel>? = null
    var adapter: BaseAdapter<StoryItemViewModel>? = null
    private val newsList: ArrayList<NewsItemViewModel>? = null
//    private val storiesList: ArrayList<OfferItemViewModel>? = null
    fun getStories(): LiveData<List<Story>> {
        return stories
    }

    fun getNews(): LiveData<List<News>> {
        return news
    }

    fun getOffers(): LiveData<List<Offer>> {
        return offers
    }

    fun getStoriesError(): LiveData<Boolean> {
        return storiesLoadError
    }

    fun geNewstError(): LiveData<Boolean> {
        return newsLoadError
    }

    fun getOffersError(): LiveData<Boolean> {
        return offersLoadError
    }

    fun getStoriesLoading(): LiveData<Boolean> {
        return storiesLoading
    }

    fun getNewsLoading(): LiveData<Boolean> {
        return newsLoading
    }

    fun getOffersLoading(): LiveData<Boolean> {
        return offersLoading
    }

    private fun fetchStories() {
        storiesLoading.value = true
        disposable?.add(
            feedsRepository.getStories()!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<List<Story?>?>() {
                    override fun onSuccess(value: List<Story?>?) {
                        storiesLoadError.value = false
                        stories.value = value as List<Story>?
                        storiesLoading.value = false
                        addStories(stories.value!!)
                    }

                    override fun onError(e: Throwable) {
                        storiesLoadError.value = true
                        storiesLoading.value = false
                    }

                })
        )
    }

    private fun fetchNews() {
        newsLoading.value = true
        disposable?.add(
            feedsRepository.getNews()!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<List<News?>?>() {
                    override fun onSuccess(value: List<News?>?) {
                        newsLoadError.value = false
                        news.value = value as List<News>?
                        newsLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        newsLoadError.value = true
                        newsLoading.value = false
                    }

                })
        )
    }

    private fun fetchOffers() {
        offersLoading.value = true
        disposable?.add(
            feedsRepository.getOffers()!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<List<Offer?>?>() {
                    override fun onSuccess(value: List<Offer?>?) {
                        offersLoadError.value = false
                        offers.value = value as List<Offer>?
                        offersLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        offersLoadError.value = true
                        offersLoading.value = false
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
        storiesList = ArrayList<StoryItemViewModel>()
        adapter = BaseAdapter(storiesList, this)
        fetchNews()
        fetchStories();
    }

    override fun onViewClicked(position: Int, id: Int) {
//        TODO("Not yet implemented")
    }

    private fun addStories(stories: List<Story>) {

        storiesList?.clear()
        for (story in stories) {
            val StoryItemViewModel =
                StoryItemViewModel(story)
            storiesList?.add(StoryItemViewModel)
        }
        adapter?.notifyDataSetChanged()
    }
}