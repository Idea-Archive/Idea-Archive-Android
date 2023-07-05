package com.team_ia.idea_archive_android.utils.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun EditText.setOnTextChanged(action:(p0: CharSequence?, p1:Int,p2:Int,p3:Int)-> Unit){
    this.addTextChangedListener(object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int,p3: Int) = Unit
        override fun afterTextChanged(p0: Editable?) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
            action(p0, p1, p2, p3)
        }
    })
}