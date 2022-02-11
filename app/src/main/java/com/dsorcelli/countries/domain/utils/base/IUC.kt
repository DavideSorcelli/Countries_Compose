package com.dsorcelli.countries.domain.utils.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart


interface IUC {

    fun <T : IUCState> runFlow(
        startWith: T,
        onError: (Throwable) -> T,
        stream: () -> Flow<T>
    ): Flow<T> = stream()
        .onStart {
            emit(startWith)
        }
        .catch { err ->
            emit(onError(err))
        }

}