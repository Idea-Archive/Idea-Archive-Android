package com.team_ia.idea_archive_android.utils

import android.app.Activity
import android.widget.EditText
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

fun keyBoardHide(context: Activity, viewList: List<EditText>){
    viewList.forEach{ view ->
        view.clearFocus()
    }
    val window = context.window
    WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.ime())
}

fun keyBoardShow(context: Activity, view: EditText) {
        view.requestFocus()
}