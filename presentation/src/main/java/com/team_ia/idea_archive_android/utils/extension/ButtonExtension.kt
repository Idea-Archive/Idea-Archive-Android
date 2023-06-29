package com.team_ia.idea_archive_android.utils.extension

import android.widget.Button

fun Button.changeAtivatedWithEnabled(activiated: Boolean){
    isActivated = activiated
    isEnabled = isActivated
}