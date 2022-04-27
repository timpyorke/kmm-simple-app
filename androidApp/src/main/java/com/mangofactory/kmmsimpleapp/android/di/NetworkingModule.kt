package com.mangofactory.kmmsimpleapp.android.di

import com.mangofactory.kmmsimpleapp.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    fun providePostService(): PostService = PostService()
}