package com.eja.covidinfoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eja.covidinfoapp.api.ApiEndpoint
import com.eja.covidinfoapp.api.ApiService.getRetrofitService
import com.eja.covidinfoapp.model.CountryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<CountryModel>()

    fun setCountryData() {
        val retrofit = getRetrofitService()
        val apiEndpoint = retrofit.create(ApiEndpoint::class.java)
        val call = apiEndpoint.getSummaryIdn()
        call.enqueue(object : Callback<CountryModel> {
            override fun onResponse(call: Call<CountryModel>, response: Response<CountryModel>) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<CountryModel>, t: Throwable) {

            }
        })
    }

    fun getCountryData(): LiveData<CountryModel> {
        return mutableLiveData
    }
}