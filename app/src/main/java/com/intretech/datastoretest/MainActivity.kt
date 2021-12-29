package com.intretech.datastoretest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.intretech.datastoretest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {
        binding.btnPreferenceDs.setOnClickListener {
           startActivity(Intent(this, PDSActivity::class.java))
        }

        binding.btnProtoDs.setOnClickListener {
            startActivity(Intent(this, ProtoActivity::class.java))
        }
    }
}
