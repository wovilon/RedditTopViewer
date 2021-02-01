package com.example.reddittopviewer.ui.topList

import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reddittopviewer.R
import com.example.reddittopviewer.model.Publication
import com.example.reddittopviewer.ui.adapters.TopAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityContract.MainView {
    val presenter = MainActivityPresenter(this)
    var isLoading = false
    var publications = ArrayList<Publication>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) presenter.getTopFromAPI()
        else{
            publications = savedInstanceState.getSerializable("pub") as ArrayList<Publication>
            updateTop(publications)
            isLoading = true
        }


    }

    override fun updateTop(items: ArrayList<Publication>) {
        publications.addAll(items)
        isLoading = false
        val adapter = TopAdapter(publications, this, this)
        rvTop.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvTop.layoutManager = layoutManager
        rvTop.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (layoutManager.findLastVisibleItemPosition() > publications.size-2){
                    isLoading = true
                    presenter.getTopFromAPI()
                }


            }
        })

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("pub", publications)
    }



}