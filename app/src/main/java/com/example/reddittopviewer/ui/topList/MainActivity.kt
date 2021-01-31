package com.example.reddittopviewer.ui.topList

import ResponseMain
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.reddittopviewer.R
import com.example.reddittopviewer.model.Publication
import com.example.reddittopviewer.ui.adapters.TopAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract.MainView {
    val presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getTopFromAPI()
    }

    override fun updateTop(items: ArrayList<Publication>) {
        val adapter = TopAdapter(items, this)
        rvTop.adapter = adapter
        rvTop.layoutManager = LinearLayoutManager(this)
    }


}