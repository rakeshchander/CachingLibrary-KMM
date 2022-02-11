package io.github.rc

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

/**
 * Interface for Caching Layer
 */
expect class CachingLayer() {
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
inline fun <reified T> CachingLayer.getSerializedData(fileName: String) : @Serializable T? {
    val content = getContent(fileName)
    return content?.let { jsonParser.decodeFromString<T>(it) }
}

/**
 * Default Implementation for Caching Layer Interface methods
 */
inline fun <reified T> CachingLayer.putSerializedData(fileName: String, content: @Serializable T) {
    val jsonContent = jsonParser.encodeToString(content)
    saveContent(fileName, jsonContent)
}
