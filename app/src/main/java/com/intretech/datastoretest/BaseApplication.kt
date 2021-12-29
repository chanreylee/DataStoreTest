package com.intretech.datastoretest

import android.app.Application

/**
 * @PackageName:com.intretech.datastoretest
 * @DESC:
 * @author:  YQ16685 Chanrey Lee
 * @date 2021/12/27 - 16:06
 **/
class BaseApplication : Application() {

    companion object {
        var context: Application? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this

    }
}
