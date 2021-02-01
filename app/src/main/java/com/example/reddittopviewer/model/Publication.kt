package com.example.reddittopviewer.model

import java.io.Serializable

class Publication(authorfull: String, time: Int, imgurl: String, comments: Int) : Serializable{
    var author: String  = authorfull
    var timeAgo: Int = 0
    var thumbnail: String = ""
    var commentsNumber: Int = 0

}