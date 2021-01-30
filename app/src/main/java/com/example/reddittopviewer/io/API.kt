package com.example.reddittopviewer.io

import ResponseMain
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("top")
    fun getTopList(): Call<String>
}