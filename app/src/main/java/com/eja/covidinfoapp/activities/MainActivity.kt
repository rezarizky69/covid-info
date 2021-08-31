package com.eja.covidinfoapp.activities

import android.os.Bundle
import android.text.format.DateFormat
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.eja.covidinfoapp.R
import com.eja.covidinfoapp.fragment.CountryFragment
import com.eja.covidinfoapp.fragment.RingkasanFragment
import com.eja.covidinfoapp.fragment.RiwayatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var tvToday: TextView? = null
    var hariIni: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val ringkasanFragment = RingkasanFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.flMain, ringkasanFragment)
                .commit()
        }

        tvToday = findViewById(R.id.tvDate)
        val dateNow: Date = Calendar.getInstance().time
        hariIni = DateFormat.format("EEEE", dateNow) as String

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        getToday()
    }

    private fun getToday() {
        val date: Date = Calendar.getInstance().time
        val tanggal = DateFormat.format("d MMMM yyyy", date) as String
        val formatFix = "$hariIni,$tanggal"
        tvToday!!.text = formatFix
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.summaryMenu -> {
                val ringkasanFragment = RingkasanFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flMain, ringkasanFragment)
                    .commit()
                return true
            }
            R.id.summaryIdnMenu -> {
                val countryFragment = CountryFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flMain, countryFragment)
                    .commit()
                return true
            }
            R.id.historyMenu -> {
                val riwayatFragment = RiwayatFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flMain, riwayatFragment)
                    .commit()
                return true
            }
        }
        return false
    }
}