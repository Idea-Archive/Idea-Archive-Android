package com.team_ia.idea_archive_android.ui.profile

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.team_ia.idea_archive_android.databinding.WithdrawalMemberModalBinding

class WithdrawalModal(context: Context) : AlertDialog(context) {

    lateinit var binding: WithdrawalMemberModalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WithdrawalMemberModalBinding.inflate(layoutInflater)
        viewSetting()
    }

    private fun viewSetting() = with(binding) {
        setCancelable(true)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        btnQuit.setOnClickListener {
            cancel()
        }
    }

}