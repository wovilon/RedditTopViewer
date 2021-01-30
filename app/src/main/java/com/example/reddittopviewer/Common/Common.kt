package com.example.reddittopviewer.Common

import com.example.reddittopviewer.io.RetrofitClient
import com.example.reddittopviewer.io.API


object Common {
    private val BASE_URL = "https://www.reddit.com/"
    val retrofitService: API
        get() = RetrofitClient.getClient(BASE_URL).create(API::class.java)
}