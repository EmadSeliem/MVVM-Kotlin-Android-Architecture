package com.example.covid19.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.covid19.R
import com.example.covid19.adapters.CountryListAdapter
import com.example.covid19.data.Country
import com.example.covid19.databinding.ActivityCountriesBinding
import com.example.covid19.viewmodels.CountryListViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @AndroidEntryPoint is mandatory annotation for Dagger-Hilt
 */

@AndroidEntryPoint
class CountryListActivity : AppCompatActivity() {

    private val countryListViewModel: CountryListViewModel by viewModels()
    private lateinit var countryList: ArrayList<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCountriesBinding>(
            this,
            R.layout.activity_countries
        )

        countryList = countryListViewModel.getStaticCountryList()
        val adapter = CountryListAdapter(countryList, this)
        binding.countriesList.adapter = adapter

    }

}