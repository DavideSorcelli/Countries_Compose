package com.dsorcelli.countries.domain.utils.base


interface IUCState : BaseUCState

interface BaseUCState {
    val isLoading: Boolean
    val error: Throwable?
}
