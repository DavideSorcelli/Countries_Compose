package com.dsorcelli.countries.domain.usecase

import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.domain.repository.ICountriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetCountriesUC @Inject constructor(
    private val countriesRepository: ICountriesRepository
) : IGetCountriesUC {

    override fun invoke(): Flow<IGetCountriesUCState> {
        return runFlow(
            startWith = GetCountriesUCState(isLoading = true),
            onError = { err -> GetCountriesUCState(error = err) }
        ) {
            countriesRepository.getCountries().map {
                GetCountriesUCState(countries = it)
            }
        }
    }

}

data class GetCountriesUCState(
    override val countries: List<Country> = emptyList(),
    override val isLoading: Boolean = false,
    override val error: Throwable? = null
) : IGetCountriesUCState