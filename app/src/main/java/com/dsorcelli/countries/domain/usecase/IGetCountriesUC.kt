package com.dsorcelli.countries.domain.usecase

import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.domain.utils.base.IUCState
import com.dsorcelli.countries.domain.utils.base.IUC
import kotlinx.coroutines.flow.Flow


interface IGetCountriesUC : IUC {
    fun invoke(): Flow<IGetCountriesUCState>
}

interface IGetCountriesUCState : IUCState {
    val countries: List<Country>
}