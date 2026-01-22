package com.example.myvehicles

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import java.io.File

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

@Composable
actual fun getFilePicker(): FilePicker {
    val context = LocalContext.current
    var onResultCallback by remember { mutableStateOf<((String?) -> Unit)?>(null) }

    // Launcher για Εικόνες (Picture 2 style)
    val imageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        val path = uri?.let { FileHelper.saveToInternalStorage(context, it, "img_${System.currentTimeMillis()}") }
        onResultCallback?.invoke(path)
    }

    // Launcher για Έγγραφα - ΔΙΟΡΘΩΘΗΚΕ σε GetContent για να δείχνει Gallery/Photos (Picture 2)
    val fileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        val path = uri?.let { FileHelper.saveToInternalStorage(context, it, "doc_${System.currentTimeMillis()}") }
        onResultCallback?.invoke(path)
    }

    return remember {
        object : FilePicker {
            override fun pickImage(onResult: (String?) -> Unit) {
                onResultCallback = onResult
                imageLauncher.launch("image/*")
            }

            override fun pickFile(onResult: (String?) -> Unit) {
                onResultCallback = onResult
                // Χρησιμοποιούμε "*/*" για να επιτρέπει τα πάντα, ή "application/pdf, image/*"
                fileLauncher.launch("*/*")
            }
        }
    }
}

actual fun openFilePlatform(path: String?) {
    if (path.isNullOrEmpty()) return

    val context = globalContext
    val file = File(path)
    if (!file.exists()) return

    try {
        // Χρήση του FileProvider για ασφαλές άνοιγμα αρχείου
        val contentUri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(contentUri, context.contentResolver.getType(contentUri) ?: "*/*")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}