package com.michelle.josueru.nothogbeta

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.hotdog_dialog.view.*
import android.view.Gravity
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var hasPermissionGiven = true
    val classifer = ImageClassifier()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //set fullscreen

//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setupCameraView()

        val actionBar = supportActionBar
        actionBar!!.hide()

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        progressBar.visibility = View.GONE

        val verifying = findViewById<TextView>(R.id.verifying)

        verifying.visibility = View.GONE

        val btn_back = findViewById<Button>(R.id.btnback)
        btn_back.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }


    }

    @SuppressLint("RestrictedApi")
    private fun setupCameraView() {
        btnTakeImage.setOnClickListener { _ ->

            progressBar.visibility = View.VISIBLE
            verifying.visibility = View.VISIBLE

            cameraView.captureImage { resultImage ->
                runOnUiThread {
                    classifer.detectHotdog(resultImage.bitmap) { isHotDog ->
                        if (isHotDog) {
                            // Get the custom layout view.
                            val toastView = layoutInflater.inflate(R.layout.custom_hotdog_actionbar, null)

                            // Initiate the Toast instance.
                            val toast = Toast(applicationContext)
                            // Set custom view in toast.
                            toast.view = toastView
                            toast.duration = Toast.LENGTH_LONG
                            toast.setGravity(Gravity.TOP, 0, -22)
                            toast.show()

                            progressBar.visibility = View.GONE
                            verifying.visibility = View.GONE

                        } else {
                            val toastView = layoutInflater.inflate(R.layout.custom_nothotdog_toast, null)

                            // Initiate the Toast instance.
                            val toast = Toast(applicationContext)
                            // Set custom view in toast.
                            toast.view = toastView
                            toast.duration = Toast.LENGTH_LONG
                            toast.setGravity(Gravity.BOTTOM, 0, -22)
                            toast.show()

                            progressBar.visibility = View.GONE
                            verifying.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (hasPermissionGiven) {
            cameraView.start()
        }
    }

    override fun onPause() {
        if (hasPermissionGiven) {
            cameraView.stop()
        }
        super.onPause()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}
