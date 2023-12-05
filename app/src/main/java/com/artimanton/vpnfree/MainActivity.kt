package com.artimanton.vpnfree

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.artimanton.vpnfree.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mainBinding.root)

        mainBinding.drawerLayout.bringToFront()
        mainBinding.navigationView.setNavigationItemSelectedListener(this)
        mainBinding.navigationView.setCheckedItem(R.id.allServer)

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

        mainBinding.navOpenClose.setOnClickListener {
            if (mainBinding.drawerLayout.isDrawerVisible(GravityCompat.START)){
                mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
            }else{
                mainBinding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (mainBinding.drawerLayout.isDrawerVisible(GravityCompat.START)){
            mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            @Suppress("DEPRECATION")
            super.onBackPressed()
        }
    }
}