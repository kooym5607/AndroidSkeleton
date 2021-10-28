package com.kooym.androidskeleton.network.retrofit

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.POST

interface RetrofitService {
    @POST("test")
    fun test(
    ): Single<Boolean>
}