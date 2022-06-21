package com.example.retromodule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DtoSendJson {

    @SerializedName("message")
    @Expose
    var message : String? = null
    @SerializedName("deviceKey")
    @Expose
    var deviceKey : String? = null
    @SerializedName("transactionID")
    @Expose
    var transactionID : String? = null
}