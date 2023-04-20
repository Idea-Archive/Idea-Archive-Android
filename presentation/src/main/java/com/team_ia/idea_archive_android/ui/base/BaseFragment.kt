package com.team_ia.idea_archive_android.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B: ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : Fragment() {
    val binding get() = mBinding!!
    private var mBinding: B ?= null

    var savedInstanceState: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.savedInstanceState = savedInstanceState
        mBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        createView()
        return binding.root
    }

    abstract fun createView()
}