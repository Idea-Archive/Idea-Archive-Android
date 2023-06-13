package com.team_ia.data.remote.model

import com.google.gson.annotations.SerializedName
import com.team_ia.domain.model.PostModel as DomainPostModel
import com.team_ia.domain.model.PostModel.Member as DomainMember

data class PostModel(
    @SerializedName("postId")
    val postId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("category")
    val category: List<String>,
    @SerializedName("heartCount")
    val heartCount: Int,
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("member")
    val member: Member,
    @SerializedName("createData")
    val createData: String
) {
    data class Member(
        @SerializedName("memberId")
        val memberId: Long,
        @SerializedName("name")
        val name: String
    )

    fun Member.toEntity() = DomainPostModel.Member(
        memberId = memberId,
        name = name
    )
}

fun PostModel.toEntity() = DomainPostModel(
    postId = postId,
    title = title,
    content = content,
    category = category,
    heartCount = heartCount,
    commentCount = commentCount,
    member = DomainMember(memberId = member.memberId, name = member.name),
    createData = createData
)
