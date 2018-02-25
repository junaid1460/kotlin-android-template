package com.crook.twitterbot

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    val firstRun = "frun"
    var authenticated = "auth"
    private val mHideHandler = Handler()
    override fun onBackPressed() {


    }

      fun startMyActivity(x:Class<*>){
        var intent = Intent(this, x)
        startActivity(intent)
        finish()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var frun = getSharedPreferences(firstRun,0)
        if(!frun.getBoolean("frun",false)) {
            startMyActivity(FirstRunActivity::class.java)
        }
        else
            startMyActivity(MainActivity::class.java)
    }
}
