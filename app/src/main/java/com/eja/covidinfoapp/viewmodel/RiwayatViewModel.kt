package com.eja.covidinfoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eja.covidinfoapp.api.ApiEndpoint
import com.eja.covidinfoapp.api.ApiService.getRetrofitService
import com.eja.covidinfoapp.model.CountryModel
import com.eja.covidinfoapp.model.RiwayatModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class RiwayatViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<ArrayList<RiwayatModel>>()

    fun setTodayData() {
        val retrofit = getRetrofitService()
        val apiEndpoint = retrofit.create(ApiEndpoint::class.java)
        val call = apiEndpoint.getHistoryList(getFormattedDate())
        call.enqueue(object : Callback<List<RiwayatModel>> {
            override fun onResponse(
                call: Call<List<RiwayatModel>>,
                response: Response<List<RiwayatModel>>
            ) {
                mutableLiveData.value = response.body() as? ArrayList<RiwayatModel>
            }

            override fun onFailure(call: Call<List<RiwayatModel>>, t: Throwable) {

            }
        })
    }

    private fun getFormattedDate(): String? {
        val simpleDateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault())
        return simpleDateFormat.format(yesterday())
    }

    // fetch hari kemarin
    private fun yesterday(): Date? {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        return calendar.time
    }

    fun getTodayListData(): LiveData<ArrayList<RiwayatModel>> {
        return mutableLiveData
    }
}