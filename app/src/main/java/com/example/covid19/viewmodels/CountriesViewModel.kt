package com.example.covid19.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19.R
import com.example.covid19.data.CountryStatisticListItem
import com.example.covid19.data.CountryStatisticsList

import com.example.covid19.repository.MainRepository
import com.example.covid19.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
        private val mainRepository: MainRepository,
        @ApplicationContext private val context: Context
) :
        ViewModel() {

    private val _countryList = MutableLiveData<Resource<CountryStatisticsList>>()
    val countryStatisticListItem = MutableLiveData<CountryStatisticListItem>()
    val countryList: LiveData<Resource<CountryStatisticsList>> get() = _countryList

    fun getCountries(country: String) = viewModelScope.launch(Dispatchers.Main) {
        _countryList.postValue(Resource.loading(null))
        try {
            mainRepository.getCountries(country).let {
                if (it.isSuccessful) {
                    _countryList.postValue(Resource.success(it.body()))
                    countryStatisticListItem.postValue(it.body()?.get(0))
                } else {
                    _countryList.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        } catch (e: Exception) {
            _countryList.postValue(Resource.error(context.getString(R.string.generic_error), null))
        }
    }

}