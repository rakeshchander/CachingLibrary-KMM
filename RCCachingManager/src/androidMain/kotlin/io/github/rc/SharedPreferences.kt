package io.github.rc

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


/**
 * Android Caching Layer
 */
actual class RCUserPreferences actual constructor() {

    companion object{
        var context : Context? = null
    }

    actual fun <T> setPrefValue(keyName: String, value: T) {

        if (context != null) {

            println(keyName)
            println(value)

            val prefs : SharedPreferences = context!!.getSharedPreferences("", MODE_PRIVATE)
            val editor = prefs.edit()

            if (value is Int) {
                println("Int")
                editor.putInt(keyName, value)
                return
            }

            if (value is String) {
                println("String")
                editor.putString(keyName, value)
                return
            }

            if (value is Boolean) {
                println("Boolean")
                editor.putBoolean(keyName, value)
                return
            }

            if (value is Float) {
                println("Float")
                editor.putFloat(keyName, value)
                return
            }

            if (value is Long) {
                println("Long")
                editor.putLong(keyName, value)
                return
            }

            throw Exception("Unhandled data type")
        }

        throw Exception("Context Not Initialized")
    }

    actual fun deletePref(keyName: String) {
        if (context != null) {
            val prefs : SharedPreferences = context!!.getSharedPreferences("", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.remove(keyName)
            return
        }

        throw Exception("Context Not Initialized")
    }

    actual fun getAll() : Map<String, *> {
        if (context != null) {
            val prefs : SharedPreferences = context!!.getSharedPreferences("", MODE_PRIVATE)
            return prefs.all
        }

        throw Exception("Context Not Initialized")
    }

}

actual inline fun <reified T> RCUserPreferences.getPrefValue(keyName: String): T? {
    if (RCUserPreferences.context != null) {
        val prefs : SharedPreferences = RCUserPreferences.context!!.getSharedPreferences("", MODE_PRIVATE)

        return when (T::class.java) {
            Boolean::class.java -> prefs.getBoolean(keyName, false) as T
            Int::class.java -> prefs.getInt(keyName, 0) as T
            String::class.java -> prefs.getString(keyName, null) as? T
            Float::class.java -> prefs.getFloat(keyName, 0f) as T
            Long::class.java -> prefs.getLong(keyName, 0) as T
            else -> null
        }
    }

    return null
}

