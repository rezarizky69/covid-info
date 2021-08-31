package com.eja.covidinfoapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    fun getRetrofitService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}