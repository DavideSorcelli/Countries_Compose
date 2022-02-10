package com.dsorcelli.countries.data.source.remote

import com.dsorcelli.countries.CountriesQuery
import com.dsorcelli.countries.CountryQuery
import javax.inject.Inject


class CountriesRemoteSource @Inject constructor() : ICountriesRemoteSource {

    override fun getCountries(): List<CountriesQuery.Country> {
        return emptyList()
    }

    override fun getCountry(): CountryQuery.Country {
        return CountryQuery.Country(name = "Fake nation", code = "FN", languages = listOf(
            CountryQuery.Language(name = "fake language")
        ))
    }
}