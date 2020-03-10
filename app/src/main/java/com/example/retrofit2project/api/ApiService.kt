package com.example.retrofit2project.api

import com.example.retrofit2project.model.Quote
import com.example.retrofit2project.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("placeholder/user/{user_id}")
    suspend fun getUser(
        @Path("user_id") user_id : String
    ) : User

    @GET("posts/{user_id}")
    suspend fun getQuote(
        @Path("user_id") user_id : String
    ) : Quote

    @GET("posts")
    suspend fun getAllQuote() : List<Quote>

    //https://jsonplaceholder.typicode.com/posts/
}