package com.dsorcelli.countries.data.source.remote.mapper

import com.dsorcelli.countries.CountryQuery
import com.dsorcelli.countries.domain.model.Country


fun CountryQuery.Country.toDomain(): Country {
    return Country(
        code = this.code,
        name = this.name,
        imgUrl = "https://flagcdn.com/it.svg"
    )
}

fun List<CountryQuery.Country>.toDomain(): List<Country> {
    return map { it.toDomain() }
}