package com.team_ia.idea_archive_android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.WritePostParam
import com.team_ia.domain.usecase.post.DeletePostUseCase
import com.team_ia.domain.usecase.post.EditPostUseCase
import com.team_ia.domain.usecase.post.WritePostUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.MutableEventFlow
import com.team_ia.idea_archive_android.utils.asEvetFlow
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val writePostUseCase: WritePostUseCase,
    private val editPostUseCase: EditPostUseCase,
    private val deletePostUseCase: DeletePostUseCase
) : ViewModel() {
    private val _event = MutableLiveData<Event>()
    val event : LiveData<Event> get() = _event

    private val _categoryList = MutableLiveData<List<String>>()
    val categoryList : LiveData<List<String>> get() = _categoryList

    fun setCategoryList(category: List<String>) = viewModelScope.launch{
        _categoryList.value = category
    }

    fun writePost(title: String, content: String, category: List<String>) = viewModelScope.launch {
        writePostUseCase(
            WritePostParam(
                title, content, category
            )
        ).onSuccess {
            _event.value = Event.Success
        }.onFailure {
            Log.e("writePost", "Fail")
        }
    }

    fun upDatePost(postId: Long, title: String, content: String, category: List<String>) =
        viewModelScope.launch {
            editPostUseCase(
                postId, WritePostParam(
                    title, content, category
                )
            ).onSuccess {
                _event.value = Event.Success
            }.onFailure {
                when (it.errorHandling()) {
                    Event.NotFound -> {
                        Log.e("존재하지 않는 게시글", "404")
                    }
                    Event.Unauthorized -> {
                        Log.e("인증되지 않는 유저", "401")
                    }
                    else -> {}
                }
            }
        }

    fun deletePost(postId: Long) = viewModelScope.launch {
        deletePostUseCase(
            postId
        ).onSuccess {
            _event.value = Event.Success
        }.onFailure {
            when (it.errorHandling()) {
                Event.NotFound -> {
                        Log.e("존재하지 않는 게시글", "404")
                }
                Event.Unauthorized -> {
                        Log.e("인증되지 않는 유저", "401")
                }
                else -> {}
            }
        }
    }


}