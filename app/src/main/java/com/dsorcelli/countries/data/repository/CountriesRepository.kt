package com.dsorcelli.countries.data.repository

import com.dsorcelli.countries.data.source.remote.ICountriesRemoteSource
import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.domain.repository.ICountriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CountriesRepository @Inject constructor(
    private val remoteSource: ICountriesRemoteSource
) : ICountriesRepository {

    override fun getCountries(): Flow<List<Country>> {
        return remoteSource.getCountries()
    }

    override fun getCountry(code: String): Flow<Country> {
       return remoteSource.getCountry(code = code)
    }

}