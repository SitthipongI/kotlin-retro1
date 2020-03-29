package com.igotit.retroapp.api

import com.google.gson.GsonBuilder
import com.igotit.retroapp.model.Data
import com.igotit.retroapp.model.UserResponse
import com.igotit.retroapp.model.UserResponse1
import com.igotit.retroapp.model.jsonobj
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

public interface apiuser{
    @GET("/1/index.html")
    fun getUser() : Call<Data>

    @GET("/1/index.html")
    fun get2User() : Call<Data>

    @GET("/1/2.html")
    fun getjsonobj() : Call<UserResponse>

    @GET("/1/2.html")
    fun getjsonobj1() : Call<UserResponse1>

    companion object{
        var BASE_URL = "http://192.168.1.3"
        fun create() : apiuser{
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(apiuser::class.java)
        }
    }
}