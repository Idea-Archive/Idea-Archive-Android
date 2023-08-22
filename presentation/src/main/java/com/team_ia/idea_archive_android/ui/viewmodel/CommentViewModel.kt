package com.team_ia.idea_archive_android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.domain.param.PostCommentParam
import com.team_ia.domain.usecase.post.DeletePostUseCase
import com.team_ia.domain.usecase.post.PostCommentUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val postCommentUseCase: PostCommentUseCase,
    private val editCommentUseCase: PostCommentUseCase,
    private val deletePostUseCase: DeletePostUseCase
) : ViewModel() {
    private val _eventFlow = MutableLiveData<Event>()
    val eventFlow: LiveData<Event> get() = _eventFlow

    fun postComment(postId: Long, content: String) = viewModelScope.launch {
        postCommentUseCase(
            postId, PostCommentParam(
                content
            )
        ).onSuccess {
            _eventFlow.value = Event.Success
        }.onFailure {
            it.errorHandling(notFoundAction = {
                Log.e("존재하지 않는 글입니다", "404")
            })
        }
    }

    fun updateComment(commentId: Long, content: String) = viewModelScope.launch {
        editCommentUseCase(
            commentId, PostCommentParam(
                content
            )
        ).onSuccess {
            _eventFlow.value = Event.Success
        }.onFailure {
            when (it.errorHandling()) {
                Event.Unauthorized -> {
                    it.errorHandling(unauthorizedAction = {
                        Log.e("인증되지 않은 회원입니다.", "401")
                    })
                }
                Event.NotFound -> {
                    it.errorHandling(notFoundAction = {
                        Log.e("존재하지 않는 댓글입니다.", "404")
                    })
                }
                else -> {}
            }
        }
    }

    fun deleteComment(commentId: Long) = viewModelScope.launch {
        deletePostUseCase(
            commentId
        ).onSuccess {
            _eventFlow.value = Event.Success
        }.onFailure {
            when (it.errorHandling()) {
                Event.Unauthorized -> {
                    it.errorHandling(unauthorizedAction = {
                        Log.e("인증되지 않은 회원입니다.", "401")
                    })
                }
                Event.NotFound -> {
                    it.errorHandling(notFoundAction = {
                        Log.e("존재하지 않는 댓글입니다.", "404")
                    })
                }
                else -> {}
            }
        }
    }

}