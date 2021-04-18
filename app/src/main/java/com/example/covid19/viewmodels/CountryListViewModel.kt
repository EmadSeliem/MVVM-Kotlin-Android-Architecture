package com.example.covid19.viewmodels

import androidx.lifecycle.ViewModel
import com.example.covid19.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * The ViewModel used in [CountryListActivity].
 */
@HiltViewModel
class CountryListViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {
    /**
     * Get static list of countries ,you can add more static countries or you can replace with a BE call.
     */
    fun getStaticCountryList() = mainRepository.getStaticCountryList()

}