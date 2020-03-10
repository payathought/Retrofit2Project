package com.example.retrofit2project.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    const val BASE_URL = "https://open-api.xyz/"

    val retrofitBuilder : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService : ApiService by lazy {
        retrofitBuilder.build()
            .create(ApiService::class.java)
    }
}

object RetrofitBuilderForQuote {
    const val BASE_URL = "https://jsonplaceholder.typicode.com"

    val retrofitBuilder : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService : ApiService by lazy {
        retrofitBuilder.build()
            .create(ApiService::class.java)
    }
}