package com.eja.covidinfoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eja.covidinfoapp.api.ApiEndpoint
import com.eja.covidinfoapp.api.ApiService.getRetrofitService
import com.eja.covidinfoapp.model.CountryModel
import com.eja.covidinfoapp.model.RingkasanModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RingkasanViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<RingkasanModel>()

    fun setSummaryWorldData() {
        val retrofit = getRetrofitService()
        val apiEndpoint = retrofit.create(ApiEndpoint::class.java)
        val call = apiEndpoint.getSummaryWorld()
        call.enqueue(object : Callback<RingkasanModel> {
            override fun onResponse(
                call: Call<RingkasanModel>,
                response: Response<RingkasanModel>
            ) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<RingkasanModel>, t: Throwable) {

            }
        })
    }

    fun getSummaryWorldData(): LiveData<RingkasanModel?>? {
        return mutableLiveData
    }
}