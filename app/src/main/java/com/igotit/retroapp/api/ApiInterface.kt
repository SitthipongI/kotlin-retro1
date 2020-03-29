package com.igotit.retroapp.api

import com.igotit.retroapp.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("1/2.html")
    fun getData() : Call<UserResponse>
}