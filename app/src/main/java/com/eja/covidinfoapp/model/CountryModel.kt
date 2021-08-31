package com.eja.covidinfoapp.model

import com.google.gson.annotations.SerializedName


data class CountryModel(
    @SerializedName("lastUpdate")
    var lastUpdate: String,
    @SerializedName("confirmed")
    var idnConfirmed: IdnConfirmed,
    @SerializedName("deaths")
    var idnDeaths: IdnDeaths,
    @SerializedName("recovered")
    var idnRecovered: IdnRecovered
) {

    inner class IdnConfirmed(
        @SerializedName("value")
        var value: Int,
        @SerializedName("detail")
        var detail: String
    )

    inner class IdnDeaths(
        @SerializedName("value")
        var value: Int,
        @SerializedName("detail")
        var detail: String
    )

    inner class IdnRecovered(
        @SerializedName("value")
        var value: Int,
        @SerializedName("detail")
        var detail: String
    )
}