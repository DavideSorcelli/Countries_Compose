@file:Suppress("unused")

package com.dsorcelli.countries.domain.usecase.di

import com.dsorcelli.countries.domain.usecase.GetCountriesUC
import com.dsorcelli.countries.domain.usecase.IGetCountriesUC
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun provideGetCountriesUC(
        getCountriesUC: GetCountriesUC
    ): IGetCountriesUC

}