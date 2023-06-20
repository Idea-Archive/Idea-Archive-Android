package com.team_ia.idea_archive_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.team_ia.domain.repository.SocialRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GoogleSocialLoginViewModel @Inject constructor(
    private val socialRepository: SocialRepository
) : ViewModel(){

}