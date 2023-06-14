package com.team_ia.di

import com.team_ia.data.local.storage.AuthStorage
import com.team_ia.data.local.storage.AuthStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun provideAuthStorage(
        authStorageImpl: AuthStorageImpl
    ): AuthStorage
}