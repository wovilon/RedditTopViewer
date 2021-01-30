package com.example.reddittopviewer.ui.topList

import com.example.reddittopviewer.model.Publication

interface MainActivityContract {

    interface MainView {
        fun updateTop(items: ArrayList<Publication>)
    }

    interface Presenter{
        fun getTopFromAPI()

    }

}