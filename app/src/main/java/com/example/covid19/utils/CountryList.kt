package com.example.covid19.utils

import com.example.covid19.data.Country

object CountryList {
    private lateinit var countryList: ArrayList<Country>

    /**
     * Adding some static countries , you can add more.
     * Next webservice call needs country code in small letters.so please follow the same while adding new country.
     *
     */
    fun getCountryList(): ArrayList<Country> {
        countryList = ArrayList()
        countryList.add(Country("Egypt", "egypt"))
        countryList.add(Country("Italy", "italy"))
        countryList.add(Country("Pakistan", "pakistan"))
        countryList.add(Country("India", "india"))
        countryList.add(Country("China", "china"))
        countryList.add(Country("USA", "usa"))

        return countryList
    }
}