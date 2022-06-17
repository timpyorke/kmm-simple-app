package com.mangofactory.kmmsimpleapp.android.di

import android.content.Context
import com.mangofactory.kmmsimpleapp.android.data.PrefDataStore
import com.mangofactory.kmmsimpleapp.android.data.PrefDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideDataStore(@ApplicationContext context: Context):
            PrefDataStore = PrefDataStoreImpl(context)

}