package com.example.myvehicles

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object FileHelper {

    /**
     * Υλοποίηση Android: Αντιγράφει το αρχείο από το Uri της συσκευής
     * στον εσωτερικό κατάλογο /data/user/0/com.example.myvehicles/files/
     */
    actual fun saveToInternalStorage(context: Any, uri: Any, fileName: String): String? {
        val androidContext = context as Context
        val androidUri = uri as Uri

        return try {
            val inputStream = androidContext.contentResolver.openInputStream(androidUri)
            val extension = androidContext.contentResolver.getType(androidUri)
                ?.substringAfterLast("/") ?: "jpg"

            val file = File(androidContext.filesDir, "$fileName.$extension")
            val outputStream = FileOutputStream(file)

            inputStream?.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
            // Επιστρέφουμε το πλήρες Path (π.χ. /data/user/0/.../files/doc_123.pdf)
            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Υλοποίηση Android: Διαγράφει φυσικά το αντίγραφο του αρχείου
     * από τον εσωτερικό χώρο της εφαρμογής.
     */
    actual fun deleteFile(path: String?): Boolean {
        if (path.isNullOrEmpty()) return false
        return try {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            } else {
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}