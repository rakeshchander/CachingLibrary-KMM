package io.github.rc

import android.content.Context
import java.io.File
import java.io.FileInputStream

/**
 * Android Caching Layer
 */
actual class RCCachingManager actual constructor() {

    companion object{
        var context : Context? = null
    }

    /**
     * Save Content in Android App Specific Internal Memory
     */
    actual fun saveContent(fileName: String, content: String){
        val file = getTargetFile(fileName)

        if (file != null) {
            // If File already exists - delete that
            if (file.exists()) {
                file.delete()
            }

            // Create New File
            file.createNewFile()

            // Save contents in file
            file.appendText(content)
        }


    }

    /**
     * Retrieve Content from Android App Specific Internal Memory
     */
    actual fun getContent(fileName: String) : String?{

        val file = getTargetFile(fileName)

        if (file != null && file.exists()) {
            // Read File Contents
            // return File Contents
            return FileInputStream(file).bufferedReader().use { it.readText() }
        }

        // Return null if file doesn't exist
        return null

    }

    /**
     * Get Target File - with complete path in internal memory
     */
    fun getTargetFile(fileName: String) : File? {
        if (context != null) {
            val path = context!!.getFilesDir()
            // Create Directory in Internal Memory
            val letDirectory = File(path, "RCCachingLibrary-KMM")
            letDirectory.mkdirs()
            var targetFileName = fileName
            if (fileName.endsWith(".txt", true)) {
                targetFileName = fileName.removeSuffix(".txt")
            }
            return File(letDirectory, targetFileName + ".txt")
        }
        else return null
    }
}