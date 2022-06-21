package com.example.retromodule

interface ApiResultListner<T> {
    fun onApiResult(response : T,errorMessage:String) ;
}