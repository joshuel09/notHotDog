package com.michelle.josueru.nothogbeta

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_second_splash_nothotdog.*
import java.util.*

class second_splash_nothotdog : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_second_splash_nothotdog)
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


            //set fullscreen

            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

            val actionBar = supportActionBar
            actionBar!!.hide()

            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)







            val video = Uri.parse("android.resource://" + packageName + "/" + R.raw.nothotdog_splah)

            videoView.setVideoURI(video)

            videoView.setZOrderOnTop(true)

            videoView.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                if (isFinishing)
                    return@OnCompletionListener

                startActivity(Intent(this@second_splash_nothotdog, Home::class.java))
                finish()
            })

            videoView.start()
        }

        override fun onWindowFocusChanged(hasFocus: Boolean) {
            super.onWindowFocusChanged(hasFocus)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

