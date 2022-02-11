@file:Suppress("unused")

package com.dsorcelli.countries.data.repository.di

import com.dsorcelli.countries.data.repository.CountriesRepository
import com.dsorcelli.countries.domain.repository.ICountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountriesRepository(
        countriesRepository: CountriesRepository
    ): ICountriesRepository

}