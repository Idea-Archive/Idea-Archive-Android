package com.team_ia.domain.entity

import java.io.Serializable

data class MemberEntity(
    val email: String,
    val name: String,
    val profileImg: String?
): Serializable
