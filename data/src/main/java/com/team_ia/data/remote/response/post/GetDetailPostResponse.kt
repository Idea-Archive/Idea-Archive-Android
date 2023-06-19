package com.team_ia.data.remote.response.post

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.domain.entity.GetDetailPostEntity.Member as EntityMember
import com.team_ia.domain.entity.GetDetailPostEntity.Comment as EntityComment

data class GetDetailPostResponse(
    @SerializedName("postId")
    val postId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("category")
    val category: List<String>,
    @SerializedName("member")
    val member: Member,
    @SerializedName("comment")
    val comment: List<Comment>,
    @SerializedName("heartCount")
    val heartCount: Int,
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("applicationCount")
    val applicantCount: Int,
    @SerializedName("views")
    val views: Int,
    @SerializedName("createDate")
    val createDate: String
) {
    data class Member(
        @SerializedName("memberId")
        val memberId: Long,
        @SerializedName("name")
        val name: String
    )

    fun Member.toEntity() = GetDetailPostEntity.Member(
        memberId = memberId,
        name = name
    )

    data class Comment(
        @SerializedName("commentId")
        val commentId: Long,
        @SerializedName("content")
        val content: String,
        @SerializedName("createDate")
        val createDate: String,
        @SerializedName("member")
        val member: Member
    )

    fun Comment.toEntity() = GetDetailPostEntity.Comment(
        commentId = commentId,
        content = content,
        createDate = createDate,
        member = EntityMember(memberId = member.memberId, name = member.name)
    )
}

fun GetDetailPostResponse.toEntity() = GetDetailPostEntity(
    postId = postId,
    title = title,
    content = content,
    category = category,
    member = EntityMember(memberId = member.memberId, name = member.name),
    comment = comment.map { it.toEntity() },
    heartCount = heartCount,
    commentCount = commentCount,
    applicantCount = applicantCount,
    views = views,
    createDate = createDate
)