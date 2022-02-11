package com.dsorcelli.countries.data.api.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApolloModule {

    private const val COUNTRIES_ENDPOINT = "https://countries.trevorblades.com/"

    @Provides
    @Singleton
    fun provideCountriesBaseUrl(): String {
        return COUNTRIES_ENDPOINT
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApolloClient(
        countriesUrl: String,
        okHttpClient: OkHttpClient
    ): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(serverUrl = countriesUrl)
            .okHttpClient(okHttpClient)
            .build()
    }

}