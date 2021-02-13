package com.michelle.josueru.nothogbeta

import android.content.pm.ActivityInfo
import android.graphics.Typeface
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import android.view.WindowManager
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_about.*

class Home : AppCompatActivity() {

    private var tabLayout: TabLayout? = null
    private var appBarLayout: AppBarLayout? = null
    private var viewPager: ViewPager? = null
    private var adapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        tabLayout = findViewById(R.id.tablayout_id)
        appBarLayout = findViewById<AppBarLayout>(R.id.appbarid)
        viewPager = findViewById<ViewPager>(R.id.viewpager_id)
        adapter = ViewPagerAdapter(supportFragmentManager)

        //adding fragments
        adapter!!.AddFragment(not_hotdog_cam(), "Not Hotdog")
        adapter!!.AddFragment(About(), "About")
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)


        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)


        //set fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        //Video
        val videoview = findViewById(R.id.videoView) as VideoView
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.nothotdog_ban)
        videoview.setVideoURI(uri)
        videoview.start()
        videoview.setZOrderOnTop(true)

        videoview.setOnCompletionListener {
            videoview.setZOrderOnTop(true)
            videoview.start() //need to make transition seamless.
        }


    }

    public override fun onResume() {
        super.onResume()

        //Video
        val videoview = findViewById(R.id.videoView) as VideoView
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.nothotdog_ban)
        videoview.setVideoURI(uri)
        videoview.start()
        videoview.setZOrderOnTop(true)

        videoview.setOnCompletionListener {
            videoview.setZOrderOnTop(true)
            videoview.start() //need to make transition seamless.
        }

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
