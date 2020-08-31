package com.bdn.collinsceleb.gadsleaderboard.data.network

import com.bdn.collinsceleb.gadsleaderboard.data.models.LearningLeaders
import com.bdn.collinsceleb.gadsleaderboard.data.models.SkillLeaders
import com.bdn.collinsceleb.gadsleaderboard.data.network.LeaderboardApiConstants.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi =
    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(
            MoshiConverterFactory
                .create(moshi)
        ).addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

object LeaderboardApi {
    val retroService: LeaderboardApiService by lazy {
        retrofit.create(LeaderboardApiService::class.java)
    }
}

interface LeaderboardApiService {

    @GET("api/hours")
    fun getLearningLeadersAsync(): Deferred<List<LearningLeaders>>

    @GET("api/skilliq")
    fun getSkillLeadersAsync(): Deferred<List<SkillLeaders>>
}