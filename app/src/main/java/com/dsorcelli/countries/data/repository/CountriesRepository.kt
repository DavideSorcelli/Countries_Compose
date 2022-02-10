package com.dsorcelli.countries.data.repository

import com.dsorcelli.countries.data.source.remote.ICountriesRemoteSource
import com.dsorcelli.countries.data.source.remote.mapper.toDomain
import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.domain.repository.ICountriesRepository
import javax.inject.Inject


class CountriesRepository @Inject constructor(
    private val remoteSource: ICountriesRemoteSource
) : ICountriesRepository {

    override fun getCountries(): List<Country> {
        return remoteSource.getCountries().toDomain()
    }

    override fun getCountry(): Country {
       return Country.mockIT()
    }

}