package io.github.rc

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * Actual Implementation for Caching in Android - As expected in KMM
 */
internal actual object RCUserPreferencesImpl {
    actual fun getLayer() : RCUserPreferences {
        return RCUserPreferencesAndroid()
    }
}

/**
 * Android Caching Layer
 */
internal class RCUserPreferencesAndroid : RCUserPreferences {

    companion object{
        var context : Context? = null
    }

    override fun <T> setPrefValue(keyName: String, value: T) {

        if (context != null) {
            val prefs : SharedPreferences = context!!.getSharedPreferences("", MODE_PRIVATE)
            val editor = prefs.edit()

            if (value is Int) {
                editor.putInt(keyName, value)
                return
            }

            if (value is String) {
                editor.putString(keyName, value)
                return
            }

            if (value is Boolean) {
                editor.putBoolean(keyName, value)
                return
            }

            if (value is Float) {
                editor.putFloat(keyName, value)
                return
            }

            if (value is Long) {
                editor.putLong(keyName, value)
                return
            }
            throw Exception("Unhandled data type")
        }

        throw Exception("Context Not Initialized")
    }

    override fun deletePref(keyName: String) {
        if (context != null) {
            val prefs : SharedPreferences = context!!.getSharedPreferences("", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.remove(keyName)
            return
        }

        throw Exception("Context Not Initialized")
    }

}

internal actual inline fun <reified T> RCUserPreferences.getPrefValue(keyName: String): T? {
    if (RCUserPreferencesAndroid.context != null) {
        val prefs : SharedPreferences = RCUserPreferencesAndroid.context!!.getSharedPreferences("", MODE_PRIVATE)

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

