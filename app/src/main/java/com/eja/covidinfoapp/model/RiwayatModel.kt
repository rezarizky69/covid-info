package com.eja.covidinfoapp.model

import com.google.gson.annotations.SerializedName


data class RiwayatModel(
    @SerializedName("countryRegion")
    var countryRegion: String,
    @SerializedName("lastUpdate")
    var lastUpdate: String,
    @SerializedName("confirmed")
    var confirmed: String,
    @SerializedName("deaths")
    var deaths: String,
    @SerializedName("recovered")
    var recovered: String
)