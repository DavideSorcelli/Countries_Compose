package com.dsorcelli.countries.presentation.countries_list

sealed class CountriesEvent {
    data class Order(val countriesOrder: String) : CountriesEvent()
}