package com.intretech.datastoretest.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * @PackageName:com.intretech.datastoretest.base
 * [T] is BindingClass
 * @DESC:
 * @author:  YQ16685 Chanrey Lee
 * @date 2021/12/27 - 16:17
 **/
abstract class BaseActivity<T: ViewBinding> : AppCompatActivity() {

    private var binding: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = activityBinding() as T
        if (binding != null) {
           setContentView(binding!!.root)
        }

    }

    abstract fun activityBinding() : ViewBinding

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
