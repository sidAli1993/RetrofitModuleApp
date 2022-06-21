package com.example.retromodule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiResponse<T> {

    @SerializedName("code")
    @Expose
    var responseCode:Int?=0
    @SerializedName("message")
    @Expose
    var message:String?=null
    @SerializedName("data")
    @Expose
    var data:T?=null
    @SerializedName("error")
    @Expose
    var error:String?=null



}