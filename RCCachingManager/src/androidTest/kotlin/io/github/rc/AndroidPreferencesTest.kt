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
import android.content.SharedPreferences
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.anyInt

import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.mock


class AndroidPreferencesTest {

    @Rule
    @JvmField
    var mTempFolder = TemporaryFolder()

    @Mock
    private val mMockContext: Context = Mockito.mock(Context::class.java)

    private val testKeyName = "Key"
    private val testString = "Test"

    private var hashMap : HashMap<String, Any> = HashMap()

    @BeforeTest
    fun setUp() {

        val sharedPrefs = mock(SharedPreferences::class.java)
        val mockEdit = mock(SharedPreferences.Editor::class.java)

        MockitoAnnotations.openMocks(this)

        Mockito.`when`(mMockContext.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs)
        Mockito.`when`(sharedPrefs.edit()).thenReturn(mockEdit)

        Mockito.`when`(sharedPrefs.getString(testKeyName, null)).thenReturn(testString)

        RCUserPreferencesAndroid.context = mMockContext
    }


    @Test
    fun testActualLayer() {

        val cachingMgr = RCUserPreferencesImpl

        kotlin.test.assertTrue(cachingMgr.getLayer() is RCUserPreferencesAndroid)

    }

    @Test
    fun testSharedPrefAndroid() {
        val manager = RCUserPreferencesAndroid()

        manager.deletePref(testKeyName)

        manager.setPrefValue(keyName = testKeyName, testString)

        assert(manager.getPrefValue<String>(testKeyName) == testString)



    }

}