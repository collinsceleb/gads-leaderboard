package com.bdn.collinsceleb.gadsleaderboard.data.models

import com.squareup.moshi.Json

data class LearningLeaders(

    @Json(name = "name")
    val name: String,

    @Json(name = "hours")
    val hours: Int,

    @Json(name = "country")
    val country: String,

    @Json(name = "badgeUrl")
    val badge: String
)

