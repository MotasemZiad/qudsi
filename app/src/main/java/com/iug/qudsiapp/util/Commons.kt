package com.iug.qudsiapp.util

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*

object Commons {

    fun setLocale(lang: String, context: Context) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context.resources
            .updateConfiguration(config, context.resources.displayMetrics)
    }

}