package com.michelle.josueru.nothogbeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton

class not_hotdog_cam : Fragment() {

    internal lateinit var view: View
    fun not_hotdog_cam() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.activity_not_hotdog_cam, container, false)

        val imageButton = view.findViewById(R.id.nothotdog) as ImageButton
        imageButton.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return view

    }
}
