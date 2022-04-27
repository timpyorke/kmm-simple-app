package com.mangofactory.kmmsimpleapp.android.di

import com.mangofactory.kmmsimpleapp.android.domain.GetPostListUseCase
import com.mangofactory.kmmsimpleapp.android.domain.GetPostListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetPostListUseCase(getPostListUseCaseImpl: GetPostListUseCaseImpl): GetPostListUseCase
}