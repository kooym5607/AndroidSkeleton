package com.kooym.androidskeleton

import android.app.Application
import com.kooym.androidskeleton.utils.MyPrefs

class MyApp: Application() {
    companion object {
        lateinit var prefs : MyPrefs
    }

    override fun onCreate() {
        prefs = MyPrefs(applicationContext)
        super.onCreate()
    }





}