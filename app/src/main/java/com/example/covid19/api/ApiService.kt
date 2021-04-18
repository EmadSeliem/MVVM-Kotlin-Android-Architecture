package com.example.covid19.api

import com.example.covid19.data.CountryStatisticsList
import retrofit2.Response
import retrofit2.http.*


interface ApiService {
    @Headers(
        "x-rapidapi-key: 15bc5e4031msh9723b40eb216c70p1038e2jsn4798a1e58c2e",
        "useQueryString: true",
        "Accept:application/json"
    )
    @GET("country")
    suspend fun getCountries(@Query("name") country: String): Response<CountryStatisticsList>
}