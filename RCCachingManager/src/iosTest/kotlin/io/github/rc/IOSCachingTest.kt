package io.github.rc

import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertTrue

class IOSCachingTest {

    @Test
    fun testCachingIOSFileName() {
        val manager = CachingLayer()

        val fileName = "rc-sample.txt"

        val filePath = manager.getTargetFile(fileName)

        assertTrue(filePath.startsWith("/Users"))
        assertTrue(filePath.endsWith(fileName))
    }

    @Test
    fun testCachingIOS() {
        val manager = CachingLayer()

        val fileName = "rc-sample.txt"

        manager.saveContent(fileName, "Test")

        val fileContents = manager.getContent(fileName)

        assertTrue(fileContents != null)
        assertTrue(fileContents == "Test")
    }



}