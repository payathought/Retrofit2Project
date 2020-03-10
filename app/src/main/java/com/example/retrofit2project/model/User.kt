package com.example.retrofit2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(

    @Expose
    @SerializedName("email")
    val email: String? = null,

    @Expose
    @SerializedName("username")
    val username: String? = null,

    @Expose
    @SerializedName("image")
    val image: String? = null
){
    override fun toString(): String {
        return "User(email=$email, username=$username, image=$image)"
    }
}

data class Quote(

    @SerializedName("id")
    val id : String? = null,
    @SerializedName("title")
    val title : String? = null,
    @SerializedName("body")
    val body : String? = null
)
