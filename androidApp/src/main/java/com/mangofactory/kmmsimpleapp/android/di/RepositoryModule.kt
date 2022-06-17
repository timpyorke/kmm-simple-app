package com.mangofactory.kmmsimpleapp.android.di

import com.mangofactory.kmmsimpleapp.PostRepository
import com.mangofactory.kmmsimpleapp.PostRepositoryImpl
import com.mangofactory.kmmsimpleapp.networking.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePostRepository(postService: PostService): PostRepository =
        PostRepositoryImpl(postService)
}