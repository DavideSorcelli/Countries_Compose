package com.dsorcelli.countries.data.source.remote

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.dsorcelli.countries.CountriesQuery
import com.dsorcelli.countries.CountryQuery
import com.dsorcelli.countries.data.source.remote.mapper.toDomain
import com.dsorcelli.countries.domain.model.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class CountriesRemoteSource @Inject constructor(
    private val countriesClient: ApolloClient
) : ICountriesRemoteSource {

    override fun getCountries(): Flow<List<Country>> {
        return countriesClient.query(CountriesQuery()).toFlow()
            .map {
                it.data!!.countries.toDomain()
            }
    }

    override fun getCountry(code: String): Flow<Country> {
        return countriesClient.query(CountryQuery(code = code)).toFlow()
            .map { it.data!!.country!!.toDomain() }
    }
}