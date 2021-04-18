package com.example.covid19.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19.R
import com.example.covid19.data.Country
import com.example.covid19.databinding.CountryItemBinding
import com.example.covid19.ui.CountryStatisticsActivity

class CountryListAdapter(
    private val countryList: ArrayList<Country>,
    private val mContext: Context
) :
    RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CountryItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.country_item,
            parent, false
        )
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    inner class ViewHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            binding.callBack = this@CountryListAdapter
            binding.executePendingBindings()
        }

    }

    fun calBack(country: Country) {
        val intent = Intent(mContext, CountryStatisticsActivity::class.java)
        intent.putExtra("COUNTRY_CODE", country.countryCode)
        mContext.startActivity(intent)
    }

}