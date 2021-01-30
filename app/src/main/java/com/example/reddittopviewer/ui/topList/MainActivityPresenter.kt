package com.example.reddittopviewer.ui.topList

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter(val mainView: MainActivityContract.MainView) : MainActivityContract.Presenter{

    override fun getTopFromAPI() {
        val subscribe = MainActivityAPI().getTopPublications()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                { v -> mainView.updateTop(v) },
                { e -> })
    }

}