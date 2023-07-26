package com.team_ia.idea_archive_android.ui.write

import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.databinding.FragmentSelectMajorBinding
import com.team_ia.idea_archive_android.ui.base.BaseFragment
import com.team_ia.idea_archive_android.ui.viewmodel.WriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectMajorFragment : BaseFragment<FragmentSelectMajorBinding>(R.layout.fragment_select_major) {
    private val writeViewModel by activityViewModels<WriteViewModel>()
    override fun createView() {
        onClick()
    }

    companion object{
        var front = false
        var web = false
        var back = false
        var android = false
        var ios = false
        var design = false
        var devops = false
        var ai = false
        var game = false
        var dba = false
        var embedded = false
        var security = false
    }

    private fun onClick() = binding.apply{
        val majorList: MutableList<String> = mutableListOf("구인")
        btnMajorFront.setOnClickListener {
            front = when(front){
                false -> {
                    majorList.add("프론트엔드")
                    btnMajorFront.setBackgroundResource(R.drawable.bg_major_frontend_seleted_btn)
                    true
                }
                true -> {
                    majorList.remove("프론트엔드")
                    btnMajorFront.setBackgroundResource(R.drawable.bg_major_frontend_btn)
                    false
                }
            }
        }
        btnMajorWeb.setOnClickListener {
            web = when(web){
                false -> {
                    majorList.add("웹퍼블리셔")
                    btnMajorWeb.setBackgroundResource(R.drawable.bg_major_web_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("웹퍼블리셔")
                    btnMajorWeb.setBackgroundResource(R.drawable.bg_major_web_btn)
                    false
                }
            }
        }
        btnMajorBack.setOnClickListener {
            back = when(back){
                false -> {
                    majorList.add("백엔드")
                    btnMajorBack.setBackgroundResource(R.drawable.bg_major_back_seleceted_btn)
                    true
                }
                true -> {
                    majorList.remove("백엔드")
                    btnMajorBack.setBackgroundResource(R.drawable.bg_major_back_btn)
                    false
                }
            }
        }
        btnMajorAndroid.setOnClickListener {
            android = when(android) {
                false -> {
                    majorList.add("안드로이드")
                    btnMajorAndroid.setBackgroundResource(R.drawable.bg_major_android_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("안드로이드")
                    btnMajorAndroid.setBackgroundResource(R.drawable.bg_major_android_btn)
                    false
                }
            }
        }
        btnMajorIos.setOnClickListener {
            ios = when(ios) {
                false -> {
                    majorList.add("iOS")
                    btnMajorIos.setBackgroundResource(R.drawable.bg_major_ios_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("iOS")
                    btnMajorIos.setBackgroundResource(R.drawable.bg_major_ios_btn)
                    false
                }
            }
        }
        btnMajorDesign.setOnClickListener {
            design = when(design){
                false -> {
                    majorList.add("디자인")
                    btnMajorDesign.setBackgroundResource(R.drawable.bg_major_design_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("디자인")
                    btnMajorDesign.setBackgroundResource(R.drawable.bg_major_design_btn)
                    false
                }
            }
        }
        btnMajorDevops.setOnClickListener {
            devops = when(devops){
                false -> {
                    majorList.add("DevOps")
                    btnMajorDevops.setBackgroundResource(R.drawable.bg_major_devops_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("DevOps")
                    btnMajorDevops.setBackgroundResource(R.drawable.bg_major_devops_btn)
                    false
                }
            }
        }
        btnMajorAi.setOnClickListener {
            ai = when(ai){
                false -> {
                    majorList.add("AI")
                    btnMajorAi.setBackgroundResource(R.drawable.bg_major_ai_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("AI")
                    btnMajorAi.setBackgroundResource(R.drawable.bg_major_ai_btn)
                    false
                }
            }
        }
        btnMajorGame.setOnClickListener {
            game = when(game){
                false -> {
                    majorList.add("게임개발")
                    btnMajorGame.setBackgroundResource(R.drawable.bg_major_game_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("게임개발")
                    btnMajorGame.setBackgroundResource(R.drawable.bg_major_game_btn)
                    false
                }
            }
        }
        btnMajorDba.setOnClickListener {
            dba = when(dba){
                false -> {
                    majorList.add("DBA")
                    btnMajorDba.setBackgroundResource(R.drawable.bg_major_dba_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("DBA")
                    btnMajorDba.setBackgroundResource(R.drawable.bg_major_dba_btn)
                    false
                }
            }
        }
        btnMajorEmbedded.setOnClickListener {
            embedded = when(embedded){
                false -> {
                    majorList.add("임베디드")
                    btnMajorEmbedded.setBackgroundResource(R.drawable.bg_major_embedded_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("임베디드")
                    btnMajorEmbedded.setBackgroundResource(R.drawable.bg_major_embedded_btn)
                    false
                }
            }
        }
        btnMajorSecurity.setOnClickListener {
            security = when(security){
                false -> {
                    majorList.add("보안")
                    btnMajorSecurity.setBackgroundResource(R.drawable.bg_major_security_selected_btn)
                    true
                }
                true -> {
                    majorList.remove("보안")
                    btnMajorSecurity.setBackgroundResource(R.drawable.bg_major_security_btn)
                    false
                }
            }
        }
        btnNextButton.setOnClickListener {
            writeViewModel.setCategoryList(majorList)
            requireActivity().findNavController(R.id.write_container)
                .navigate(R.id.action_selectMajorFragment_to_writeFragment)
        }
    }

    override fun observeEvent() {

    }
}