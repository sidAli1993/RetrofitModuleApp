package com.example.retrofitmoduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.retromodule.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    val textView: TextView? = null
    var arrayList = ArrayList<Users?>()
    var dummyJson: String = "{\n" +
            "\t\"userId\": 1,\n" +
            "\t\"id\": 1,\n" +
            "\t\"title\": \"delectus aut autem\",\n" +
            "\t\"completed\": false\n" +
            "}"
    lateinit var button1: Button
    lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        var dtoSendJson = DtoSendJson()
        dtoSendJson.message = dummyJson

        button1.setOnClickListener(View.OnClickListener {
            dtoSendJson.deviceKey = "6666f9db070a5aee"
            dtoSendJson.transactionID = "11888"
            RestClient.getUsers(dtoSendJson,
                object : ApiResultListner<ApiResponse<ArrayList<Users?>?>?> {
                    override fun onApiResult(
                        response: ApiResponse<ArrayList<Users?>?>?,
                        errorMessage: String
                    ) {

//                arrayList= response?.data!!
//                for (i in arrayList){
//                    Log.e("Arrayist Items", i!!.accountTitle.toString())
//                }

                    }

                })

        })

        button2.setOnClickListener(View.OnClickListener {
            dtoSendJson.deviceKey = "622094b0defda8f7"
            dtoSendJson.transactionID = "11999"
            RestClient.getUsers(dtoSendJson,
                object : ApiResultListner<ApiResponse<ArrayList<Users?>?>?> {
                    override fun onApiResult(
                        response: ApiResponse<ArrayList<Users?>?>?,
                        errorMessage: String
                    ) {

//                arrayList= response?.data!!
//                for (i in arrayList){
//                    Log.e("Arrayist Items", i!!.accountTitle.toString())
//                }

                    }

                })
        })



//        RestClient.getUsers(object : ApiResultListner<ApiResponse<ArrayList<Users>>> {
//            override fun onApiResult(
//                response: ApiResponse<ArrayList<Users>>,
//                errorMessage: String
//            ) {
//
//            }
//        })

    }
}


