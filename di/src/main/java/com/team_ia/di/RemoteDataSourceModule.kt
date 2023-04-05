package com.team_ia.di

import com.team_ia.data.remote.datasource.*
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
    ): AuthDataSource

    @Binds
    abstract fun providePostDataSource(
        postDataSourceImpl: PostDataSourceImpl
    ): PostDataSource

    @Binds
    abstract fun provideMemberDataSource(
        memberDataSourceImpl: MemberDataSourceImpl
    ): MemberDataSource

    @Binds
    abstract fun provideEmailDataSource(
        emailDataSourceImpl: EmailDataSourceImpl
    ): EmailDataSource

    @Binds
    abstract fun provideAdminDataSource(
        adminDataSourceImpl: AdminDataSourceImpl
    ): AdminDataSource

    @Binds
    abstract fun provideImgDataSource(
        imgDataSourceImpl: ImgDataSourceImpl
    ): ImgDataSource

    @Binds
    abstract fun provideApplicationDataSource(
        applicationDataSourceImpl: ApplicationDataSourceImpl
    ): ApplicationDataSource
}