package com.team_ia.data.remote.request.post

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.param.SearchPostParam

data class SearchPostRequest (
    @SerializedName("category")
    val category: List<String>
)

fun SearchPostParam.toRequest() = SearchPostRequest(
    category = category
)