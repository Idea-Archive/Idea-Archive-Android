package com.team_ia.data.remote.datasource.img

import com.team_ia.data.remote.api.ImgAPI
import javax.inject.Inject

class ImgDataSourceImpl @Inject constructor(
    private val imgAPI: ImgAPI
) : ImgDataSource {
}