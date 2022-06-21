package com.example.retromodule

import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList
import java.util.concurrent.TimeUnit

val BASE_URL = "http://192.168.18.17:3000/"
var retrofit: Retrofit? = null
var webService: WebService? = null
object RestClient {

    private fun getRetrofit(): Retrofit? {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(logging)
        }
        val gson = GsonBuilder()
            .serializeNulls()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
        httpClient.addInterceptor(Interceptor { chain ->
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url
            val url = originalHttpUrl.newBuilder()
                .build()
            val requestBuilder: Request.Builder = original.newBuilder()
                .url(url)
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        })
        httpClient.readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
        return retrofit
    }

    private fun getClient(): WebService? {
        if (webService == null) {
            webService = getRetrofit()?.create(WebService::class.java)
        }
        return webService
    }

    fun getUsers(valuetoSend : DtoSendJson,resultLitener: ApiResultListner<ApiResponse<ArrayList<Users?>?>?>) {
        val apiResponseCall: Call<ApiResponse<ArrayList<Users?>?>?>? = getClient()!!.getUsers(valuetoSend)
        apiResponseCall!!.enqueue(object : Callback<ApiResponse<ArrayList<Users?>?>?> {
            override fun onResponse(
                call: Call<ApiResponse<ArrayList<Users?>?>?>,
                response: Response<ApiResponse<ArrayList<Users?>?>?>
            ) {
                resultLitener.onApiResult(response.body(), "null")
            }

            override fun onFailure(
                call: Call<ApiResponse<ArrayList<Users?>?>?>,
                t: Throwable
            ) {
                resultLitener.onApiResult(null, t.message!!)
            }
        })
    }
}


