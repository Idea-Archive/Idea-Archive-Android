package com.team_ia.di

import com.team_ia.data.remote.datasource.AuthDataSourceImpl
import com.team_ia.data.remote.datasource.AuthDatasource
import com.team_ia.data.remote.datasource.PostDataSource
import com.team_ia.data.remote.datasource.PostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun provideAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDatasource

    @Binds
    abstract fun providePostDataSource(
        postDataSourceImpl: PostDataSourceImpl
    ): PostDataSource
}