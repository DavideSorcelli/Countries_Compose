package com.dsorcelli.countries.data.source.remote

import com.dsorcelli.countries.CountriesQuery
import com.dsorcelli.countries.CountryQuery


interface ICountriesRemoteSource {
    fun getCountries(): List<CountriesQuery.Country>
    fun getCountry(): CountryQuery.Country
}