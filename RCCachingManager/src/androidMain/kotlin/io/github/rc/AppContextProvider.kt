package io.github.rc

import android.content.Context
import androidx.startup.Initializer

/**
 * Android App Context Provider
 * KotlinX Implementation to simplify SDK Initialization
 */
class AppContextProvider : Initializer<Context> {
    override fun create(context: Context) : Context {
        CachingLayer.context = context
        RCUserPreferences.context = context
        return context
    }
    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }
}
