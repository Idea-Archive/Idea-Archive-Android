package com.team_ia.data.remote.datasource

import com.team_ia.data.remote.api.SocialAPI
import javax.inject.Inject

class SocialDataSourceImpl @Inject constructor(
    private val socialAPI: SocialAPI
) : SocialDataSource {
}