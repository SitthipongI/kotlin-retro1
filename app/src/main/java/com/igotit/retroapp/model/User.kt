package com.igotit.retroapp.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("name")
    var name: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("email")
    var email: String
)

object Model {
    data class result_json(val info: info_json)
    data class info_json(val info: user_json)
    data class user_json(val id:String,val name: String, val email: String)
}