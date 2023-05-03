package com.team_ia.domain.entity

data class GetApplicantEntity(
    val applicationResponse: List<Member>
) {
    data class Member(
        val memberId: Long,
        val name: String
    )
}