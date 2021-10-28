package com.kooym.androidskeleton

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

class BaseApplication : Application() {
    init {
        instance = this
    }
    companion object{
        private var instance: BaseApplication? = null
        fun getContext(): Context{
            return instance!!.applicationContext
        }
    }

}