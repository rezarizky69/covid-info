package com.eja.covidinfoapp.model

import com.google.gson.annotations.SerializedName


data class RingkasanModel(
    @SerializedName("lastUpdate")
    var lastUpdate: String,
    @SerializedName("confirmed")
    var confirmed: Confirmed,
    @SerializedName("deaths")
    var deaths: Deaths,
    @SerializedName("recovered")
    var recovered: Recovered) {

    inner class Confirmed(
        @SerializedName("value")
        var value: Int,
        @SerializedName("detail")
        var detail: String
    )

    inner class Deaths(
        @SerializedName("value")
        var value: Int,
        @SerializedName("detail")
        var detail: String
    )

    inner class Recovered(
        @SerializedName("value")
        var value: Int,
        @SerializedName("detail")
        var detail: String
    )
}