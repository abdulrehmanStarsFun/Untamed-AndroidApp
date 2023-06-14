package com.example.uhunt.jet.tiktokclassess.countrypicker

import com.example.uhunt.jet.tiktokclassess.countrypicker.CountryCode

fun List<CountryCode>.searchCountryList(key: String): MutableList<CountryCode> {
    val tempList = mutableListOf<CountryCode>()
    this.forEach {
        if (it.countryName.lowercase().contains(key.lowercase())) {
            tempList.add(it)
        }
    }
    return tempList
}