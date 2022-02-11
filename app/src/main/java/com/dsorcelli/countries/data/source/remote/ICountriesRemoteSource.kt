package com.dsorcelli.countries.data.source.remote

import com.dsorcelli.countries.domain.model.Country
import kotlinx.coroutines.flow.Flow


interface ICountriesRemoteSource {
    fun getCountries(): Flow<List<Country>>
    fun getCountry(code: String): Flow<Country>
}