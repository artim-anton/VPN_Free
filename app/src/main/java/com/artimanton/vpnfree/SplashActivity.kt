package com.artimanton.vpnfree

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.WindowInsets
import android.view.WindowManager
import com.artimanton.vpnfree.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val downloadBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(downloadBinding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else{
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val activityOptions = ActivityOptions.makeCustomAnimation(this@SplashActivity, 0, 0)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java), activityOptions.toBundle())
            finish()
        }, 1000)

        val progress = downloadBinding.progressBar
        progress.max = 1000
        val currentProgress = 1000

        ObjectAnimator.ofInt(progress, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }
}