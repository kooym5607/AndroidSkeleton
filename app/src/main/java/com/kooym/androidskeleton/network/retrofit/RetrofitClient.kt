package com.kooym.androidskeleton.network.retrofit

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.kooym.androidskeleton.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object{
        private var retrofitClient: RetrofitService? = null
        fun getClient(): RetrofitService?{
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            if(BuildConfig.DEBUG)
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            else
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
            val client = OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()

            if(retrofitClient == null){
                retrofitClient = Retrofit.Builder()
                    .baseUrl("http://vandalfarm.com/vandalhub/app/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build().create(RetrofitService::class.java)
            }
            return retrofitClient
        }
    }
}