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
            if (prefs == null) {
                throw NullPointerException("Kprefs not initialized. Data won't save...")
            } else {
                prefs!!.edit().putString(key, Gson().toJson(value)).apply()
            }
        }

        fun <T> get(key: String, type: Type): T? {
            val x: T?

            if (prefs == null) {
                throw NullPointerException("Kprefs not initialized. Data won't save...")
            } else {
                x = Gson().fromJson(prefs!!.getString(key, ""), type)
            }
            return x
        }
    }
}