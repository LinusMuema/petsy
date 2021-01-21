package com.moose.petsy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.moose.petsy.R
import com.moose.petsy.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        lifecycleScope.launch { runAnimation() }
        setContentView(binding.root)
    }

    private suspend fun runAnimation(){
        binding.splashMotion.transitionToState(R.id.end)
        delay(3000)
        startActivity(Intent(this, MainActivity::class.java))
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        finish()
    }
}