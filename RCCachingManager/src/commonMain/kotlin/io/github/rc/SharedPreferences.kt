package io.github.rc


/**
 * Interface for Caching Layer
 */
internal interface RCUserPreferences {
    fun <T> setPrefValue(keyName: String, value: T)
    fun deletePref(keyName: String)
}

internal expect inline fun <reified T> RCUserPreferences.getPrefValue(keyName: String) : T?

/**
 * Expectation of Implementation of Caching Layer in respective Library - Android, iOS, JS
 */
internal expect object RCUserPreferencesImpl {
    fun getLayer() : RCUserPreferences
}