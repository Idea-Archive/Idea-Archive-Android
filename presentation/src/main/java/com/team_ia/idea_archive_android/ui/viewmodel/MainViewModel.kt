package com.team_ia.idea_archive_android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.entity.GetDetailPostEntity
import com.team_ia.domain.model.PostModel
import com.team_ia.domain.param.SearchPostParam
import com.team_ia.domain.usecase.post.*
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.MutableEventFlow
import com.team_ia.idea_archive_android.utils.asEvetFlow
import com.team_ia.idea_archive_android.utils.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getPopularPostUseCase: GetPopularPostUseCase,
    private val getCategoryPostUseCase: GetCategoryPostUseCase,
    private val getDetailPostUseCase: GetDetailPostUseCase,
    private val postHeartUseCase: PostHeartUseCase
) : ViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    private val _postData = MutableLiveData<List<PostModel>>()
    val postData: LiveData<List<PostModel>> get() = _postData

    private val _categoryPostData = MutableLiveData<List<PostModel>>()
    val categoryPostData: LiveData<List<PostModel>> get() = _categoryPostData

    private val _detailPostData = MutableLiveData<GetDetailPostEntity>()
    val detailPostData: LiveData<GetDetailPostEntity> get() = _detailPostData

    fun getPost() = viewModelScope.launch {
        getPostUseCase().onSuccess {
            _postData.value = it
            event(Event.Success)
        }.onFailure {
            Log.e("글 가져오기", "실패 $it")
        }
    }

    fun getPopularPost() = viewModelScope.launch {
        getPopularPostUseCase().onSuccess {
            _postData.value = it
            event(Event.Success)
        }.onFailure {
            Log.e("인기 글 가져오기", "실패")
        }
    }

    fun getCategoryPost(category: List<String>) = viewModelScope.launch {
        getCategoryPostUseCase(
            SearchPostParam(
                category
            )
        ).onSuccess {
            _categoryPostData.value = it
            event(Event.Success)
        }.onFailure {
            Log.e("카테고리별 글 가져오기", "실패")
        }
    }

    fun getDetailPost(postId: Long) = viewModelScope.launch {
        getDetailPostUseCase(
            postId = postId
        ).onSuccess {
            _detailPostData.value = it
            event(Event.Success)
        }.onFailure {
            event(it.errorHandling(notFoundAction = {
                Log.e("존재하지 않는 게시글", "404")
            }))
        }
    }

    fun heartPost(postId: Long) = viewModelScope.launch {
        postHeartUseCase(
            postId
        ).onSuccess {
            event(Event.Success)
        }.onFailure {
            event(it.errorHandling(notFoundAction = {
                Log.e("존재하지 않는 게시글", "404")
            }))
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }


}