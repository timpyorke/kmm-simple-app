package com.mangofactory.kmmsimpleapp.android.common.executor

import com.mangofactory.kmmsimpleapp.android.common.executor.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object FakeCoroutineDispatcherProvider : CoroutineDispatcherProvider {

    override fun io(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }

    override fun main(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }
}
