package com.team_ia.idea_archive_android.utils.extension

import android.widget.Button

fun Button.changeActivatedWithEnabled(activated:Boolean){
    isActivated = activated
    isEnabled = isActivated
}