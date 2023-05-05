package com.team_ia.data.remote.response.application

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.entity.GetApplicantEntity

data class GetApplicantResponse(
    @SerializedName("ApplicationResponse")
    val applicationResponse: List<Member>
) {
    data class Member(
        @SerializedName("memberId")
        val memberId: Long,
        @SerializedName("name")
        val name: String
    )

    fun Member.toEntity() = GetApplicantEntity.Member(
        memberId = memberId,
        name = name
    )
}

fun GetApplicantResponse.toEntity() = GetApplicantEntity(
    applicationResponse = applicationResponse.map { it.toEntity() }
)