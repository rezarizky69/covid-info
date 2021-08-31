package com.eja.covidinfoapp.api

import com.eja.covidinfoapp.model.CountryModel
import com.eja.covidinfoapp.model.RingkasanModel
import com.eja.covidinfoapp.model.RiwayatModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoint {

    @GET(Api.END_POINT_WORLD_HISTORY)
    fun getHistoryList(
        @Path("date") date: String?
    ): Call<List<RiwayatModel>>

    @GET(Api.END_POINT_SUMMARY)
    fun getSummaryWorld(): Call<RingkasanModel>

    @GET(Api.END_POINT_IDN)
    fun getSummaryIdn(): Call<CountryModel>
}