package com.islamdidarmd.kprefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.google.gson.Gson
import java.lang.reflect.Type

class Kprefs {

    companion object {
        val TAG = "Kprefs"

        private var prefs: SharedPreferences? = null

        fun initDefault(context: Context) {
            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
            }
        }

        fun init(prefs: SharedPreferences) {
            this.prefs = prefs
        }

        fun save(key: String, value: Any) {
            try {
                prefs!!.edit().putString(key, Gson().toJson(value)).apply()
            } catch (e: NullPointerException) {
                Log.d(TAG, "Kprefs not initialized. Data won't save...")
            }

        }

        fun <T> get(key: String, type: Type): T? {
            var x: T?
            try {
                x = Gson().fromJson(prefs!!.getString(key, ""), type)
            } catch (e: NullPointerException) {
                x = null
                Log.d(TAG, "Kprefs not initialized. Data won't save...")
            }
            return x
        }
    }
}