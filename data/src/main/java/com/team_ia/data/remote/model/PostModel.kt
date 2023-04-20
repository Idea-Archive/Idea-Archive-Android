package com.team_ia.data.remote.model

import com.google.gson.annotations.SerializedName

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
    val member: List<Member>,
    @SerializedName("createData")
    val createData: String
) {
    data class Member(
        @SerializedName("memberId")
        val memberId: Long,
        @SerializedName("name")
        val name: String
    )

    fun Member.toEntity() = PostModel.Member(
        memberId = memberId,
        name = name
    )
}

fun PostModel.toEntity() = PostModel(
    postId = postId,
    title = title,
    content = content,
    category = category,
    heartCount = heartCount,
    commentCount = commentCount,
    member = member.map { it.toEntity() },
    createData = createData
)
