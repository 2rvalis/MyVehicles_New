package com.example.myvehicles

import platform.Foundation.*
import platform.posix.memcpy
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual object FileHelper {
    actual fun saveToInternalStorage(context: Any?, uriString: String, fileName: String): String? {
        val fileManager = NSFileManager.defaultManager
        // Εύρεση του φακέλου Documents στο iOS (αντίστοιχο του internal storage)
        val documentsDirectory = fileManager.URLForDirectory(
            NSDocumentDirectory,
            NSUserDomainMask,
            null,
            true,
            null
        ) ?: return null

        val sourceURL = NSURL.URLWithString(uriString) ?: return null
        val extension = sourceURL.pathExtension ?: "bin"
        val destinationURL = documentsDirectory.URLByAppendingPathComponent("$fileName.$extension") ?: return null

        // Αντιγραφή των δεδομένων από το προσωρινό URL του picker στο μόνιμο φάκελο της εφαρμογής
        val data = NSData.dataWithContentsOfURL(sourceURL) ?: return null
        return if (data.writeToURL(destinationURL, true)) {
            destinationURL.path
        } else {
            null
        }
    }

    actual fun deleteFile(path: String?) {
        if (path.isNullOrEmpty()) return
        val fileManager = NSFileManager.defaultManager
        if (fileManager.fileExistsAtPath(path)) {
            fileManager.removeItemAtPath(path, null)
        }
    }
}