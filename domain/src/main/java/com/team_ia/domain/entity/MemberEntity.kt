package com.team_ia.domain.entity

import com.team_ia.domain.model.PostModel

data class MemberEntity(
    val email: String,
    val password: String,
    val profileImg: String,
    val myHeartList: List<PostModel>,
    val myPost: List<PostModel>
)
