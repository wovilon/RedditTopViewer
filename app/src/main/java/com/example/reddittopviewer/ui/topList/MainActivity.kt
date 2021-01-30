package com.example.reddittopviewer.ui.topList

import ResponseMain
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.reddittopviewer.Common.Common
import com.example.reddittopviewer.R
import com.example.reddittopviewer.io.API
import com.example.reddittopviewer.model.Publication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainActivityContract.MainView {
    val presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getTopFromAPI()
    }

    override fun updateTop(items: ArrayList<Publication>) {
        Log.d("MyLOG", "ttt")
    }


}