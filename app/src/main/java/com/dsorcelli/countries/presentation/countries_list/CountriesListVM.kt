package com.dsorcelli.countries.presentation.countries_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.domain.usecase.IGetCountriesUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CountriesListVM @Inject constructor(
    private val getCountriesUC: IGetCountriesUC
) : ViewModel() {

    private val _state = mutableStateOf(CountriesState())
    val state: State<CountriesState> = _state

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        getCountriesUC.invoke()
            .onEach {
                when {
                    it.isLoading -> {
                        _state.value = CountriesState(refreshing = true)
                    }
                    it.error != null -> {

                    }
                    else -> {
                        _state.value = CountriesState(
                            countries = it.countries
                        )
                    }
                }
                Log.d("DAVE", "getCountriesUC state: $it")
            }.launchIn(viewModelScope)
    }

    fun refresh() {
        fetchCountries()
    }

    fun onEvent(event: CountriesEvent) {
        when (event) {
            is CountriesEvent.Order -> {
                // TODO: uc with ordering
            }
        }
    }

}

data class CountriesState(
    val countries: List<Country> = emptyList(),
    val countriesOrder: String = "DESC",
    val refreshing: Boolean = false
)