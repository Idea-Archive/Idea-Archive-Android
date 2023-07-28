package com.team_ia.domain.entity

data class GetDetailPostEntity(
    val postId: String,
    val title: String,
    val content: String,
    val category: List<String>,
    val member: Member,
    val comment: List<Comment>,
    val heartCount: Int,
    val commentCount: Int,
    val applicantCount: Int,
    val views: Int,
    val createDate: String
){
    data class Member(
        val memberId: Long,
        val name: String
    )

    data class Comment(
        val commentId: Long,
        val content: String,
        val createDate: String,
        val member: Member
    )

    fun Comment.toEntity() = GetDetailPostEntity.Comment(
        commentId = commentId,
        content = content,
        createDate = createDate,
        member = member
    )
}
