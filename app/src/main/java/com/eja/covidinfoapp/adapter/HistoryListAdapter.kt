package com.eja.covidinfoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eja.covidinfoapp.R
import com.eja.covidinfoapp.model.RiwayatModel


class HistoryListAdapter(private val context: Context) :
    RecyclerView.Adapter<HistoryListAdapter.ViewHolder>() {

    private val riwayatModels: ArrayList<RiwayatModel> = ArrayList()

    fun getRiwayatModels(): ArrayList<RiwayatModel> {
        return riwayatModels
    }

    fun setRiwayatModels(items: ArrayList<RiwayatModel>) {
        if (riwayatModels.size > 0) {
            riwayatModels.clear()
        }
        riwayatModels.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.history_item_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lastUpdateDate.text = riwayatModels[position].lastUpdate
        holder.tvConfirmed.text = riwayatModels[position].confirmed
        holder.tvRecovered.text = riwayatModels[position].recovered
        holder.tvDeath.text = riwayatModels[position].deaths
        holder.tvListCountry.text = "Negara : " + riwayatModels[position].countryRegion
    }

    override fun getItemCount(): Int {
        return riwayatModels.size
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var lastUpdateDate: TextView
        var tvConfirmed: TextView
        var tvRecovered: TextView
        var tvDeath: TextView
        var tvListCountry: TextView

        init {
            lastUpdateDate = itemView.findViewById(R.id.tvListLastUpdate)
            tvConfirmed = itemView.findViewById(R.id.tvListConfirmed)
            tvRecovered = itemView.findViewById(R.id.tvListRecovered)
            tvDeath = itemView.findViewById(R.id.tvListDeath)
            tvListCountry = itemView.findViewById(R.id.tvListCountry)
        }
    }
}