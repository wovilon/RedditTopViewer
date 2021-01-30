package com.example.reddittopviewer

import ResponseMain
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.reddittopviewer.Common.Common
import com.example.reddittopviewer.io.API

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        mService.getTopList().enqueue(object : Callback<ResponseMain> {
            override fun onFailure(call: Call<ResponseMain>, t: Throwable) {
                Log.d("MyLOG", "err")
            }

            override fun onResponse(call: Call<ResponseMain>, response: Response<ResponseMain>) {
                //adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                Log.d("MyLOG", response.body().toString())
            }
        })
    }


}