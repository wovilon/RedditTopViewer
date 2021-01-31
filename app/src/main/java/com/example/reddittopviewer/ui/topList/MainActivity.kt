package com.example.reddittopviewer.ui.topList

import ResponseMain
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.reddittopviewer.R
import com.example.reddittopviewer.model.Publication
import com.example.reddittopviewer.ui.adapters.TopAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract.MainView {
    val presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getTopFromAPI()
    }

    override fun updateTop(items: ArrayList<Publication>) {
        val adapter = TopAdapter(items, this, this)
        rvTop.adapter = adapter
        rvTop.layoutManager = LinearLayoutManager(this)
    }

    override fun showBigImage(url: String) {
        Picasso.get().load(url).into(ivBigImage);
        ivBigImage.visibility = View.VISIBLE

        MediaStore.Images.Media.insertImage(
            contentResolver,
            ivBigImage.drawable.toBitmap(),
            "title",
            "Image of title"
        )
    }

    override fun hideBigImage() {
        ivBigImage.visibility = View.GONE
    }

    override fun onBackPressed() {
        if (ivBigImage.visibility == View.VISIBLE) ivBigImage.visibility = View.GONE
        else super.onBackPressed()

    }


}