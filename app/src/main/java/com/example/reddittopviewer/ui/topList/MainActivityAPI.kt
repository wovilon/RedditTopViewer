package com.example.reddittopviewer.ui.topList

import ResponseMain
import android.util.Log
import com.example.reddittopviewer.Common.Common
import com.example.reddittopviewer.io.API
import com.example.reddittopviewer.model.Publication
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class MainActivityAPI {
    lateinit var mService: API

    fun getTopPublications() =
        Observable.create<ArrayList<Publication>> { emitter ->
            mService = Common.retrofitService
            mService.getTopList().enqueue(object : Callback<ResponseMain> {
                override fun onFailure(call: Call<ResponseMain>, t: Throwable) {
                    Log.d("MyLOG", "err")
                }

                override fun onResponse(
                    call: Call<ResponseMain>,
                    response: Response<ResponseMain>
                ) {
                    //adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                    Log.d("MyLOG", response.body().toString())

                    val publications = ArrayList<Publication>()
                    if (response.body()?.data != null) {
                        for (item in response.body()!!.data.children) {
                            publications.add(
                                Publication(
                                    item.data.author ?: "",
                                    calculateTimeAgo(item.data.approved_at_utc ?: 0),
                                    item.data.thumbnail ?: "",
                                    item.data.num_comments ?: 0
                                )
                            )
                        }
                    }
                    emitter.onNext(publications)
                }
            })

        }

    private fun calculateTimeAgo(value: Long?): Int{
        var hours = 0;
        if (value != null){
            hours = TimeUnit.MILLISECONDS.toHours((System.currentTimeMillis() - value * 1000)).toInt()
        }
        return  hours
    }
}