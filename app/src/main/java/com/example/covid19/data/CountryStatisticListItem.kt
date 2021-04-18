package com.example.covid19.data

data class CountryStatisticListItem(
    val code: String,
    val confirmed: Int,
    val country: String,
    val critical: Int,
    val deaths: Int,
    val lastChange: String,
    val lastUpdate: String,
    val latitude: Double,
    val longitude: Double,
    val recovered: Int
)