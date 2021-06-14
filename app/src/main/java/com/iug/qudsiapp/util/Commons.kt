package com.iug.qudsiapp.util

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*

object Commons {

    const val IS_NIGHT = "isNight"

    fun getSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)

    fun getSharedEditor(context: Context) : SharedPreferences.Editor = getSharedPreferences(context).edit()

    fun setLocale(lang: String, context: Context) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context.resources
            .updateConfiguration(config, context.resources.displayMetrics)
    }

}