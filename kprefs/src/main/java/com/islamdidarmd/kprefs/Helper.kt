package com.islamdidarmd.kprefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.google.gson.Gson
import java.lang.reflect.Type

object Kprefs {
    val TAG = "Kprefs"

    var prefs: SharedPreferences? = null
    val gson by lazy {
        Gson()
    }

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
            prefs!!.edit().putString(key, gson.toJson(value)).apply()
        }
    }

    inline fun <reified T> get(key: String): T? {
        val x: T?

        if (prefs == null) {
            throw NullPointerException("Kprefs not initialized. Data won't save...")
        } else {
            x = gson.fromJson(prefs!!.getString(key, ""), T::class.java)
        }
        return x
    }
}