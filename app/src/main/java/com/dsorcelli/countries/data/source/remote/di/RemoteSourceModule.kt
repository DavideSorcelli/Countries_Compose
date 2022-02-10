package com.dsorcelli.countries.data.source.remote.di

import com.dsorcelli.countries.data.source.remote.CountriesRemoteSource
import com.dsorcelli.countries.data.source.remote.ICountriesRemoteSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {

    @Binds
    @Singleton
    abstract fun bindCountriesRemoteSource(
        countriesRemoteSource: CountriesRemoteSource
    ): ICountriesRemoteSource

}