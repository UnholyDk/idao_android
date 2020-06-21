package com.example.android.idao.network

import com.example.android.idao.News
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

private const val BASE_URL = "https://api.idao.world/api/"

const val APP_TOKEN = "ZEThR0gCa2Rdw0QwmuQST2A6Zt019d-PilQqfKx9eAc="

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface IdaoApiService {
    @Headers("Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App")
    @GET("accounts")
    fun getAccounts() : Call<List<PersonProperty>>

    @GET("news")
    fun getNews() : Call<List<News>>

    @POST("auth/login")
    fun authorization(@Body userData: UserInfo) : Deferred<DataForApi>
}

object IdaoApi {
    val retrofitService: IdaoApiService by lazy { retrofit.create(IdaoApiService::class.java) }
}