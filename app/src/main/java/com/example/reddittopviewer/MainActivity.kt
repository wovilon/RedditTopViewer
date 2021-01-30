package com.example.reddittopviewer

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
        mService.getTopList().enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("MyLOG", "err")
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                //adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                Log.d("MyLOG", response.body().toString())
            }
        })
    }


}