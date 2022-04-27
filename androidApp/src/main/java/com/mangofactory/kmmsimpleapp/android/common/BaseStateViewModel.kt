package com.mangofactory.kmmsimpleapp.android.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mangofactory.kmmsimpleapp.android.common.executor.CoroutineDispatcherProvider
import com.mangofactory.kmmsimpleapp.android.common.executor.CoroutineDispatcherProviderImpl
import com.mangofactory.kmmsimpleapp.android.common.listenable.Disposable


abstract class BaseStateViewModel<VS : Any, VE : Any>(
    protected val dispatcherProvider: CoroutineDispatcherProvider = CoroutineDispatcherProviderImpl(),
    initialState: VS,
) : ViewModel() {

    protected val compositeDisposable: MutableList<Disposable> = mutableListOf()

    protected val mutableState = MutableLiveData(initialState)
    val state: LiveData<VS> = mutableState
    val currentState get() = mutableState.value!!

    private val mutableEvent: SingleLiveEvent<VE> = SingleLiveEvent()
    val event: LiveData<VE> = mutableEvent

    protected fun postState(value: VS) {
        mutableState.postValue(value)
    }

    protected inline fun postState(builder: VS.() -> VS) {
        postState(currentState.builder())
    }

    protected fun setState(value: VS) {
        mutableState.value = value
    }

    protected inline fun setState(builder: VS.() -> VS) {
        mutableState.value = currentState.builder()
    }

    protected fun postEvent(value: VE) {
        mutableEvent.postValue(value)
    }

    protected fun setEvent(value: VE) {
        mutableEvent.value = value
    }

    override fun onCleared() {
        compositeDisposable.forEach {
            it.dispose()
        }
        super.onCleared()
    }
}
