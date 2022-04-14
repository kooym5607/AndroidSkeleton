package com.kooym.androidskeleton.utils

import android.content.Context
import android.content.SharedPreferences

class MyPrefs(context: Context) {
    private val prefsFilename = "prefs"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFilename, 0)

}