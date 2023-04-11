package com.team_ia.di

import com.team_ia.data.remote.datasource.*
import com.team_ia.data.remote.datasource.admin.AdminDataSource
import com.team_ia.data.remote.datasource.admin.AdminDataSourceImpl
import com.team_ia.data.remote.datasource.application.ApplicationDataSource
import com.team_ia.data.remote.datasource.application.ApplicationDataSourceImpl
import com.team_ia.data.remote.datasource.auth.AuthDataSource
import com.team_ia.data.remote.datasource.auth.AuthDataSourceImpl
import com.team_ia.data.remote.datasource.email.EmailDataSource
import com.team_ia.data.remote.datasource.email.EmailDataSourceImpl
import com.team_ia.data.remote.datasource.img.ImgDataSource
import com.team_ia.data.remote.datasource.img.ImgDataSourceImpl
import com.team_ia.data.remote.datasource.member.MemberDataSource
import com.team_ia.data.remote.datasource.member.MemberDataSourceImpl
import com.team_ia.data.remote.datasource.post.PostDataSource
import com.team_ia.data.remote.datasource.post.PostDataSourceImpl
import com.team_ia.data.remote.datasource.social.SocialDataSource
import com.team_ia.data.remote.datasource.social.SocialDataSourceImpl
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

    @Binds
    abstract fun provideSocialDataSource(
        socialDataSourceImpl: SocialDataSourceImpl
    ): SocialDataSource
}