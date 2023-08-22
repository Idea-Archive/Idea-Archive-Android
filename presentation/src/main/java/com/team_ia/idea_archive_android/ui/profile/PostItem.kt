package com.team_ia.idea_archive_android.ui.profile

import androidx.activity.viewModels
import com.team_ia.domain.model.PostModel
import com.team_ia.idea_archive_android.R
import com.team_ia.idea_archive_android.adapter.CategoryListAdapter
import com.team_ia.idea_archive_android.databinding.ItemPostBinding
import com.team_ia.idea_archive_android.ui.base.BaseActivity
import com.team_ia.idea_archive_android.ui.viewmodel.MyViewModel

class PostItem(private val data: PostModel) : BaseActivity<ItemPostBinding>(R.layout.item_post) {
    private lateinit var adapter: CategoryListAdapter
    private val viewModel by viewModels<MyViewModel>()


    override fun createView() {
    }

    override fun observeEvent() {
    }

    fun initRecycler() {
        adapter = CategoryListAdapter(viewModel.postData.value)
        binding.rvCategory.adapter = adapter
    }

}