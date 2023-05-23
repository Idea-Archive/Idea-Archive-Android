package com.team_ia.di

import com.team_ia.data.remote.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideOkhttpClient(
    ): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideAuthAPI(retrofit: Retrofit): AuthAPI =
        retrofit.create(AuthAPI::class.java)

    @Provides
    fun providePostAPI(retrofit: Retrofit): PostAPI =
        retrofit.create(PostAPI::class.java)

    @Provides
    fun provideMemberAPI(retrofit: Retrofit): MemberAPI =
        retrofit.create(MemberAPI::class.java)

    @Provides
    fun provideEmailAPI(retrofit: Retrofit): EmailAPI =
        retrofit.create(EmailAPI::class.java)

    @Provides
    fun provideAdminAPI(retrofit: Retrofit): AdminAPI =
        retrofit.create(AdminAPI::class.java)

    @Provides
    fun provideImgAPI(retrofit: Retrofit): ImgAPI =
        retrofit.create(ImgAPI::class.java)

    @Provides
    fun provideApplicationAPI(retrofit: Retrofit): ApplicationAPI =
        retrofit.create(ApplicationAPI::class.java)

    @Provides
    fun provideSocialAPI(retrofit: Retrofit): SocialAPI =
        retrofit.create(SocialAPI::class.java)
}