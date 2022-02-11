package io.github.rc

import android.content.Context
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.test.BeforeTest

class AndroidCachingTest {

    @Rule
    @JvmField
    var mTempFolder = TemporaryFolder()

    @Mock
    private val mMockContext: Context? = null

    @BeforeTest
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        Mockito.`when`(mMockContext!!.filesDir).thenReturn(mTempFolder.newFolder())

        CachingLayer.context = mMockContext
    }

    @Test
    fun testCachingAndroidFileName() {
        val manager = CachingLayer()

        val fileName = "rc-sample.txt"

        val file = manager.getTargetFile(fileName)

        kotlin.test.assertTrue(file != null)
    }

    @Test
    fun testCachingAndroid() {
        val manager = CachingLayer()

        val fileName = "rc-sample.txt"

        manager.saveContent(fileName, "Test")

        val fileContents = manager.getContent(fileName)

        kotlin.test.assertTrue(fileContents != null)
        kotlin.test.assertTrue(fileContents == "Test")
    }

}