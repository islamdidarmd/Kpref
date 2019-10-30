package com.didar.sharedprefshelper

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.islamdidarmd.kprefs.Kprefs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //save values in a default sharedPreference
        Kprefs.initDefault(this)

        Kprefs.save("test", 10)

        val x: Int? = Kprefs.get("")


        //save values in your preference
        val pref = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        Kprefs.init(pref)

        Kprefs.save("testMyPref", "Saved")

        val value: String? = Kprefs.get("")
    }
}
