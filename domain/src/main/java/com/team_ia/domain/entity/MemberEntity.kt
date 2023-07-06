package com.team_ia.domain.entity

import com.team_ia.domain.model.PostModel

data class MemberEntity(
    val email: String,
    val name: String,
    val profileImg: String?
)
