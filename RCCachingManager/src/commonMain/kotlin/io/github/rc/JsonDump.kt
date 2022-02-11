package io.github.rc

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Interface for Caching Layer
 */
expect class RCCachingManager() {
    fun saveContent(fileName: String, content: String)
    fun getContent(fileName: String) : String?
}

/**
 * JSON Parser SetUp
 */
val jsonParser = Json { prettyPrint = true; isLenient = true; ignoreUnknownKeys = true }

/**
 * Default Implementation for Caching Layer Interface methods
 */
inline fun <reified T> RCCachingManager.getSerializedData(fileName: String) : @Serializable T? {
    val content = getContent(fileName)
    return content?.let { jsonParser.decodeFromString<T>(it) }
}

/**
 * Default Implementation for Caching Layer Interface methods
 */
inline fun <reified T> RCCachingManager.putSerializedData(fileName: String, content: @Serializable T) {
    val jsonContent = jsonParser.encodeToString(content)
    saveContent(fileName, jsonContent)
}
