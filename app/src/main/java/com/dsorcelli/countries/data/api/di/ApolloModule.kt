package com.dsorcelli.countries.data.api.di

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApolloModule {

    private const val COUNTRIES_ENDPOINT = "https://github.com/trevorblades/countries"

    @Provides
    @Singleton
    fun provideCountriesBaseUrl(): String {
        return COUNTRIES_ENDPOINT
    }

    @Provides
    @Singleton
    fun provideApolloClient(
        countriesUrl: String
    ): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(serverUrl = countriesUrl)
            .build()
    }

}