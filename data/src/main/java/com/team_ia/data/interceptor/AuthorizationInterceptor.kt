package com.team_ia.data.interceptor

import com.google.gson.Gson
import com.team_ia.data.BuildConfig
import com.team_ia.data.local.storage.AuthStorage
import com.team_ia.data.remote.response.auth.LoginResponse
import com.team_ia.domain.exception.NeedLoginException
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val authDataStorage: AuthStorage
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val ignorePath = listOf(
            "/auth/signup",
            "/auth/login",
            "/email/send",
            "/email",
            "/post",
            "/post/{postId}",
            "/post/search",
            "/post/popular",
            "/post/category"
        )
        if (ignorePath.contains(path)) return chain.proceed(request)
        val refreshToken = authDataStorage.getRefreshToken()
        if(!refreshToken.isNullOrBlank()) {
            val expiredAt = LocalDateTime.parse(
                authDataStorage.getExpiredAt(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME
            )
            val currentTime = LocalDateTime.now()
            if (currentTime.isAfter(expiredAt)) {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("${BuildConfig.BASE_URL}/auth")
                    .patch("".toRequestBody("application/json".toMediaTypeOrNull()))
                    .addHeader("refreshToken", "${authDataStorage.getRefreshToken()}")
                    .build()
                val response = client.newCall(request).execute()
                if(response.isSuccessful) {
                    val token = Gson().fromJson(
                        response.body!!.toString(),
                        LoginResponse::class.java
                    )
                    authDataStorage.setAccessToken(access = token.accessToken)
                    authDataStorage.setRefreshToken(refresh = token.refreshToken)
                    authDataStorage.setExpiredAt(expiredAt = token.expiredAt)
                } else throw NeedLoginException()
            }
            return chain.proceed(
                request.newBuilder().addHeader(
                    "Authorization",
                    "Bearer ${authDataStorage.getAccessToken()}"
                ).build()
            )
        }
        return chain.proceed(request)
    }
}