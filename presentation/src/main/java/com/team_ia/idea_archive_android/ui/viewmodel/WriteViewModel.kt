package com.team_ia.idea_archive_android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team_ia.domain.param.WritePostParam
import com.team_ia.domain.usecase.post.WritePostUseCase
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.MutableEventFlow
import com.team_ia.idea_archive_android.utils.asEvetFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WriteViewModel @Inject constructor(
    private val writePostUseCase: WritePostUseCase
): ViewModel(){
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    fun writePost(title: String, content: String, category: List<String>) = viewModelScope.launch{
        writePostUseCase(
            WritePostParam(
                title, content, category
            )
        ).onSuccess {
            event(Event.Success)
        }.onFailure {
            Log.e("writePost","Fail")
        }
    }

    private fun event(event: Event) = viewModelScope.launch{
        _eventFlow.emit(event)
    }

}