package com.igotit.retroapp.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("info")
    var info:List<userx>

)

data class jsonobj(
    @SerializedName("a")
    var obja: String,
    @SerializedName("b")
    var objb: String
)