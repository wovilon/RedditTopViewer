package com.example.reddittopviewer.model

data class Publication (
    val author: String  = "",
    val timeAgo: Int = 0,
    val thumbnail: String = "",
    val commentsNumber: Int = 0
)