package com.moose.petsy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moose.petsy.databinding.ActivityMainBinding
import com.moose.petsy.utils.Icons
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.navBar.apply {
            adapter = NavListAdapter(Icons.list)
        }

        setContentView(binding.root)
    }
}