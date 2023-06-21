package com.team_ia.idea_archive_android.ui.main

import android.view.View
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.ActivityLoginPageBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.utils.extension.changeActivatedWithEnabled
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page ){
    override fun createView() {
        binding.login
        initView()
    }

    private fun initView() = binding.apply {
        etEmail.run {
            setOnTextChanged { p0, _, _, _ ->
                btnLogin.changeActivatedWithEnabled(!p0.isNullOrBlank()&& !binding.etPassword.text.isNullOrBlank())
            }
            setOnFocusChangeListener{_,b ->
                etEmail.isActivated = b
            }
        }
        etPassword.run {
            setOnTextChanged { p0, _, _, _ ->
                btnLogin.changeActivatedWithEnabled(!p0.isNullOrBlank()&& !binding.etEmail.text.isNullOrBlank())
            }
            setOnFocusChangeListener{_,b ->
                etPassword.isActivated = b
            }
        }
    }
    
}