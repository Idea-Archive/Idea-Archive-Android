package com.team_ia.di

import com.team_ia.data.repository.AuthRepositoryImpl
import com.team_ia.data.repository.PostRepositoryImpl
import com.team_ia.domain.repository.AuthRepository
import com.team_ia.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun providePostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}