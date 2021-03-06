package io.github.rc

import platform.Foundation.NSUserDefaults
import platform.darwin.NSInteger

/**
 * This is actual implementation of Caching Layer in iOS
 */
actual class RCUserPreferences actual constructor() {
    actual fun <T> setPrefValue(keyName: String, value: T) {

        if (value is NSInteger) {
            NSUserDefaults.standardUserDefaults.setInteger(value, keyName)
            return
        }

        if (value is String) {
            NSUserDefaults.standardUserDefaults.setObject(value, keyName)
            return
        }

        if (value is Boolean) {
            NSUserDefaults.standardUserDefaults.setBool(value, keyName)
            return
        }

        if (value is Float) {
            NSUserDefaults.standardUserDefaults.setFloat(value, keyName)
            return
        }

        if (value is Long) {
            NSUserDefaults.standardUserDefaults.setObject(value, keyName)
            return
        }

        throw Exception("Unhandled data type")
    }

    actual fun deletePref(keyName: String) {
        val prefs : NSUserDefaults = NSUserDefaults.standardUserDefaults
        prefs.removeObjectForKey(keyName)
    }
}

actual inline fun <reified T> RCUserPreferences.getPrefValue(keyName: String): T? {
    val prefs : NSUserDefaults = NSUserDefaults.standardUserDefaults

    return when (T::class) {
        Boolean::class -> prefs.boolForKey(keyName) as? T
        Int::class -> prefs.integerForKey(keyName) as? T
        String::class -> prefs.objectForKey(keyName) as? T
        Float::class -> prefs.floatForKey(keyName) as? T
        Long::class -> prefs.objectForKey(keyName) as? T
        else -> null
    }
}
