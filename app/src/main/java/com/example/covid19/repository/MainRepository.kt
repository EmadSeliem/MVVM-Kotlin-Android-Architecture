package com.example.covid19.repository

import com.example.covid19.api.ApiService
import com.example.covid19.utils.CountryList
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCountries(country: String) = withContext(IO) { apiService.getCountries(country) }
    fun getStaticCountryList() = CountryList.getCountryList()
}