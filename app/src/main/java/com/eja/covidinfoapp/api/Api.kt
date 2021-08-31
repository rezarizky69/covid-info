package com.eja.covidinfoapp.api

class Api {

    companion object {
        const val BASE_URL: String = "https://covid19.mathdro.id"
        const val END_POINT_SUMMARY: String = "/api"
        const val END_POINT_IDN: String = "/api/countries/IDN"
        const val END_POINT_WORLD_HISTORY: String = "/api/daily/{date}"
    }

}