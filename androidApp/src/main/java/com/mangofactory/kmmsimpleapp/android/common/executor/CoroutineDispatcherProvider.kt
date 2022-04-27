package com.mangofactory.kmmsimpleapp.android.common.executor

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher
}
