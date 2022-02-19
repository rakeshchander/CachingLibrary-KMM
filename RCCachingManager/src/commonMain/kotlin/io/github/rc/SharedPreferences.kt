package io.github.rc


/**
 * Interface for Caching Layer
 */
expect class RCUserPreferences() {
    fun <T> setPrefValue(keyName: String, value: T)
    fun deletePref(keyName: String)
    fun getAll() : Map<String, *>
}

expect inline fun <reified T> RCUserPreferences.getPrefValue(keyName: String) : T?
