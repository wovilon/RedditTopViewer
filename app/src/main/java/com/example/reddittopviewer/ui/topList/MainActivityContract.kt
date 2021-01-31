package com.example.reddittopviewer.ui.topList

import com.example.reddittopviewer.model.Publication

interface MainActivityContract {

    interface MainView {
        fun updateTop(items: ArrayList<Publication>)
        fun showBigImage(url: String)
        fun hideBigImage()
    }

    interface Presenter{
        fun getTopFromAPI()

    }

}