package com.team_ia.domain.model

data class PostModel(
    val postId: String,
    val title: String,
    val content: String,
    val category: List<String>,
    val heartCount: Int,
    val commentCount: Int,
    val member: Member,
    val heart: Boolean,
    val createDate: String
) {
    data class Member(
        val memberId: Long,
        val name: String,
        val profileImage: String?
    )

    fun Member.toEntity() = PostModel.Member(
        memberId = memberId,
        name = name,
        profileImage = profileImage
    )
}
