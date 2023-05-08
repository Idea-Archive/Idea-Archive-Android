package com.team_ia.data.local.storage

interface AuthStorage {
    fun setAccessToken(access: String?)
    fun getAccessToken(): String?

    fun setRefreshToken(refresh: String?)
    fun getRefreshToken(): String?

    fun setExpiredAt(expiredAt: String?)
    fun getExpiredAt(): String?
}