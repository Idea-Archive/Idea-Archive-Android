package com.team_ia.idea_archive_android.ui.write

import android.content.Intent
import android.util.Log
import androidx.fragment.app.activityViewModels
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentWritePageBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.main.MainActivity
import com.team_ia.idea_archive_android.ui.viewmodel.WriteViewModel
import com.team_ia.idea_archive_android.utils.Event
import com.team_ia.idea_archive_android.utils.extension.setOnTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriteFragment : BaseFragment<FragmentWritePageBinding>(R.layout.fragment_write_page) {
    private val writeViewModel by activityViewModels<WriteViewModel>()
    override fun createView() {
        textChanged()
        onClick()
    }
    private fun textChanged() = binding.apply{
        etContent.setOnTextChanged { _, _, _, _->
            tvNumberOfChar.text = etContent.length().toString() + "/500"
        }
    }

    private fun onClick() = binding.apply {
        btnNextButton.setOnClickListener {
            val category = writeViewModel.categoryList.value
            val titleText = etTitle.text.toString()
            val contentText = etContent.text.toString()
            if (titleText != null && contentText != null) {
                if (category != null) {
                    writeViewModel.writePost(titleText, contentText, category)
                }
            }
            else{
                shortToast("글을 작성해주세요")
            }
        }
    }

    override fun observeEvent() {
        observeWriteEvent()
    }

    private fun observeWriteEvent(){
        writeViewModel.event.observe(this){
            when (it){
                Event.Success -> {
                    Log.d("글 쓰기 성공","$it")
                    startActivity(Intent(context,MainActivity::class.java))
                }
                else ->{

                }
            }
        }

    }

}
