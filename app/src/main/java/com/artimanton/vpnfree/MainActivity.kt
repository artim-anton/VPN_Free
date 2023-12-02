package com.artimanton.vpnfree

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.artimanton.vpnfree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mainBinding.root)

        mainBinding.moreServers.setOnClickListener {
            val activityOptions = ActivityOptions.makeCustomAnimation(this@MainActivity, 0, 0)
            startActivity(Intent(this@MainActivity, ServerListActivity::class.java), activityOptions.toBundle())
            finish()
        }

        mainBinding.settings.setOnClickListener {
            val activityOptions = ActivityOptions.makeCustomAnimation(this@MainActivity, 0, 0)
            startActivity(Intent(this@MainActivity, SettingActivity::class.java), activityOptions.toBundle())
            finish()
        }
    }
}