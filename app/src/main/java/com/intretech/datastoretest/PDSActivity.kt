package com.intretech.datastoretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.intretech.datastoretest.databinding.ActivityPdsBinding
import com.intretech.datastoretest.databinding.ActivityProtoBinding
import com.intretech.datastoretest.utils.PDSUtil
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class PDSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPdsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pds)
        binding = ActivityPdsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
        setListener()

    }

    private fun initData() {
        runBlocking {
            PDSUtil.setUserName("Jack")
        }
    }

    private fun initView() {
    }

    private fun setListener() {
        PDSUtil.getUserName().observe(this) {
            binding.textView2.text = it
        }

        binding.textView2.setOnClickListener {
            runBlocking {
                val random = Random.nextInt() + 100
                PDSUtil.setUserName("${random%50}")
            }
        }
    }


}
