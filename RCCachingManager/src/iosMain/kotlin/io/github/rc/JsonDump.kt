package io.github.rc

import platform.Foundation.*

/**
 * This is actual implementation of Caching Layer in iOS
 */
actual class RCCachingManager actual constructor() {

    init {
        // For Public Access
    }

    /**
     * Save content in iOS Sandbox
     */
    actual fun saveContent(fileName: String, content: String){
        val fileManager = NSFileManager.defaultManager

        // Get File Path
        val filePath = getTargetFile(fileName)
        val fileURL = NSURL.fileURLWithPath(filePath)

        // Check if file already exists and delete if so
        if (fileManager.fileExistsAtPath(filePath)){
            fileManager.removeItemAtURL(fileURL, null)
        }
        // Convert contents to NSDATA
        val jsonContents = content.nsdata()

        // Write contents in file
        fileManager.createFileAtPath(filePath, jsonContents, null)

    }

    /**
     * Get Content from iOS Sandbox
     */
    actual fun getContent(fileName: String) : String?{
        val fileManager = NSFileManager.defaultManager

        // Get File Path
        val filePath = getTargetFile(fileName)

        // Check if file exists
        if (fileManager.fileExistsAtPath(filePath)){
            // Read File Contents
            // If file contents exists, convert them to JsonElement and return
            return fileManager.contentsAtPath(filePath)?.string()

        }

        // Return null
        return null
    }

    /**
     * Get Target File Path in internal memory
     */
    internal fun getTargetFile(fileName: String): String {
        // Get Documents Directory Path
        val directoryPath = NSSearchPathForDirectoriesInDomains(
            NSDocumentDirectory,
            NSUserDomainMask,
            true
        ).first() as? String
        // Append Folder name
        val targetFolderPath = directoryPath + "RCCachingLibrary-KMM"

        val fileManager = NSFileManager.defaultManager
        // Check if folder exists
        if (!fileManager.fileExistsAtPath(targetFolderPath)) {
            // Create folder for RCCachingLibrary
            fileManager.createDirectoryAtURL(
                NSURL.fileURLWithPath(targetFolderPath),
                true,
                null,
                null
            )
        }

        // Remove txt suffix if coming in fileName
        val file = fileName.removeSuffix(".txt")

        // Create complete filePath for targetFileName & internal Memory Folder
        return "$targetFolderPath/$file.txt"
    }
}

/**
 * String extension to convert to NSData
 */
@Suppress("CAST_NEVER_SUCCEEDS")
internal fun String.nsdata(): NSData? {
    return (this as NSString).dataUsingEncoding(NSUTF8StringEncoding)
}

/**
 * NSData extension to convert to String
 */
internal fun NSData.string(): String? {
    return NSString.create(this, NSUTF8StringEncoding) as String?
}