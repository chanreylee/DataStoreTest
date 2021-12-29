package com.intretech.datastoretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.intretech.datastoretest.databinding.ActivityPdsBinding
import com.intretech.datastoretest.databinding.ActivityProtoBinding
import com.intretech.datastoretest.utils.PDSUtil
import kotlinx.coroutines.runBlocking

class ProtoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProtoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_proto)
        binding = ActivityProtoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()


    }

    private fun initData() {
        runBlocking {
            PDSUtil.setAnimalName("Cat")
        }
    }

    private fun initView() {
        PDSUtil.getAnimal().observe(this) {
            binding.textView.text = it
        }

        var i = 0
        binding.textView.setOnClickListener {
            runBlocking {
                if (i%2 ==0) {
                    PDSUtil.setAnimalName("Dog")
                } else {
                    PDSUtil.setAnimalName("Cat")
                }
                i++
            }
        }

    }
}
