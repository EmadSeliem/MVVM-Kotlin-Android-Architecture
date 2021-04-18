package com.example.covid19.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.covid19.R
import com.example.covid19.databinding.ActivityCountriesBinding
import com.example.covid19.databinding.ActivityCountryStatisticsBinding
import com.example.covid19.utils.Status
import com.example.covid19.viewmodels.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryStatisticsActivity : AppCompatActivity() {

    private val countryViewModel: CountriesViewModel by viewModels()
    private lateinit var _countryName: String
    private lateinit var binding: ActivityCountryStatisticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityCountryStatisticsBinding>(
            this,
            R.layout.activity_country_statistics
        )
        binding.lifecycleOwner = this
        binding.viewModel = countryViewModel

        _countryName = intent.getStringExtra("COUNTRY_CODE").toString()
        countryViewModel.getCountries(_countryName)
        subscribeUi()

    }

   private fun subscribeUi() {
        countryViewModel.countryList.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                Status.ERROR -> binding.progressBar.visibility = View.GONE
                Status.SUCCESS -> binding.progressBar.visibility = View.GONE
            }
        })
    }
}