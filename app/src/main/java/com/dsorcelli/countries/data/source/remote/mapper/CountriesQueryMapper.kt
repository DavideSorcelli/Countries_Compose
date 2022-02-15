package com.dsorcelli.countries.data.source.remote.mapper


import com.dsorcelli.countries.CountriesQuery
import com.dsorcelli.countries.domain.model.Country

fun CountriesQuery.Country.toDomain(): Country {
    return Country(
        code = this.code,
        name = this.name,
        imgUrl = "https://flagcdn.com/w640/${this.code.lowercase()}.png"
    )
}

fun List<CountriesQuery.Country>.toDomain(): List<Country> {
    return map { it.toDomain() }
}