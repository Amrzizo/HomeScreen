package com.winfooz.homescreen.ui.fragments.offer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winfooz.homescreen.data.model.Offer
import com.winfooz.homescreen.data.remote.FeedsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OffersViewModel @Inject constructor(private val feedsRepository: FeedsRepository) :
    ViewModel() {
    private var disposable: CompositeDisposable?
    private val offers = MutableLiveData<List<Offer>>()
    private val offersLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()
    fun getOffers(): LiveData<List<Offer>> {
        return offers
    }

    fun getError(): LiveData<Boolean> {
        return offersLoadError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchOffers() {
        loading.value = true
        disposable?.add(
            feedsRepository.getOffers()!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
                    DisposableSingleObserver<List<Offer?>?>() {
                    override fun onSuccess(value: List<Offer?>?) {
                        offersLoadError.value = false
                        offers.value = value as List<Offer>?
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        offersLoadError.value = true
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
        fetchOffers()
    }
}