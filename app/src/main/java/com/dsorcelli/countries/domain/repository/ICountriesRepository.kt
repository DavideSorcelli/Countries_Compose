package com.dsorcelli.countries.domain.repository

import com.dsorcelli.countries.domain.model.Country

interface ICountriesRepository {
    fun getCountries(): List<Country>
    fun getCountry(): Country
}