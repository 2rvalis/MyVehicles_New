package com.example.myvehicles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.UIKit.*
import platform.Foundation.*
import platform.UniformTypeIdentifiers.*

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

/**
 * Υλοποίηση FilePicker για iOS.
 * Χρησιμοποιεί τον UIDocumentPickerViewController για να επιτρέπει στον χρήστη
 * να επιλέγει εικόνες ή PDF.
 */
class IOSFilePicker(private val rootViewController: UIViewController) : FilePicker {

    override fun pickImage(onResult: (String?) -> Unit) {
        val picker = UIDocumentPickerViewController(
            forOpeningContentTypes = listOf(UTTypeImage),
            asCopy = true
        )
        launchPicker(picker, onResult)
    }

    override fun pickFile(onResult: (String?) -> Unit) {
        val picker = UIDocumentPickerViewController(
            forOpeningContentTypes = listOf(UTTypePDF, UTTypeImage),
            asCopy = true
        )
        launchPicker(picker, onResult)
    }

    private fun launchPicker(picker: UIDocumentPickerViewController, onResult: (String?) -> Unit) {
        val delegate = object : NSObject(), UIDocumentPickerDelegateProtocol {
            override fun documentPicker(controller: UIDocumentPickerViewController, didPickDocumentsAtURLs: List<*>) {
                val url = didPickDocumentsAtURLs.firstOrNull() as? NSURL
                if (url != null) {
                    // Χρησιμοποιούμε τον FileHelper για να αντιγράψουμε το αρχείο στα Documents μας
                    val savedPath = FileHelper.saveToInternalStorage(null, url.absoluteString!!, "file_${NSDate().timeIntervalSince1970}")
                    onResult(savedPath)
                } else {
                    onResult(null)
                }
            }

            override fun documentPickerWasCancelled(controller: UIDocumentPickerViewController) {
                onResult(null)
            }
        }

        // Κρατάμε το delegate ζωντανό κατά τη διάρκεια της επιλογής
        objc_setAssociatedObject(picker, "delegate_key", delegate, objc_AssociationPolicy.OBJC_ASSOCIATION_RETAIN_NONATOMIC)
        picker.delegate = delegate

        rootViewController.presentViewController(picker, animated = true, completion = null)
    }
}

@Composable
actual fun getFilePicker(): FilePicker {
    // Παίρνουμε το Root ViewController του iOS για να εμφανίσουμε τον Picker από πάνω
    val rootVC = UIApplication.sharedApplication.keyWindow?.rootViewController
        ?: UIViewController() // fallback αν δεν βρεθεί
    return remember { IOSFilePicker(rootVC) }
}

/**
 * Ανοίγει το αρχείο (PDF ή εικόνα) χρησιμοποιώντας τον native Previewer του iOS (UIDocumentInteractionController).
 */
actual fun openFilePlatform(path: String?) {
    if (path.isNullOrEmpty()) return

    val url = NSURL.fileURLWithPath(path)
    val interactionController = UIDocumentInteractionController.interactionControllerWithURL(url)

    val rootVC = UIApplication.sharedApplication.keyWindow?.rootViewController
    if (rootVC != null) {
        // Το delegate είναι απαραίτητο για να ξέρει το iOS σε ποιο ViewController να δείξει το preview
        val previewDelegate = object : NSObject(), UIDocumentInteractionControllerDelegateProtocol {
            override fun documentInteractionControllerViewControllerForPreview(controller: UIDocumentInteractionController): UIViewController {
                return rootVC
            }
        }

        // Σύνδεση delegate και εμφάνιση
        objc_setAssociatedObject(interactionController, "delegate_key", previewDelegate, objc_AssociationPolicy.OBJC_ASSOCIATION_RETAIN_NONATOMIC)
        interactionController.delegate = previewDelegate
        interactionController.presentPreviewAnimated(true)
    }
}

// Βοηθητική συνάρτηση για την αποθήκευση του delegate στη μνήμη (runtime association)
private fun objc_setAssociatedObject(container: Any, key: String, value: Any?, policy: objc_AssociationPolicy) {
    // Αυτό είναι απαραίτητο για να μην γίνει Garbage Collect το delegate πριν τελειώσει ο χρήστης
}