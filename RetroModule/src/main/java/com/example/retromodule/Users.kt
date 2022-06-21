package com.example.retromodule

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id"            ) var id           : Int?    = null,
    @SerializedName("customer_id"   ) var customerId   : Int?    = null,
    @SerializedName("account_title" ) var accountTitle : String? = null,
    @SerializedName("phone"         ) var phone        : String? = null,
    @SerializedName("code"          ) var code         : Int?    = null,
    @SerializedName("balance"       ) var balance      : Double? = null,
    @SerializedName("balance_type"  ) var balanceType  : String? = null
)
