package com.dsorcelli.countries.domain.repository

import com.dsorcelli.countries.domain.model.Country
import kotlinx.coroutines.flow.Flow

interface ICountriesRepository {
    fun getCountries(): Flow<List<Country>>
    fun getCountry(code: String): Flow<Country>
}