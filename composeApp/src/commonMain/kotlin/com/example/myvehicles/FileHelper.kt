package com.example.myvehicles

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object FileHelper {
    /**
     * Αποθηκεύει ένα αρχείο από ένα Uri στον εσωτερικό χώρο αποθήκευσης της εφαρμογής.
     */
    fun saveToInternalStorage(context: Any, uri: Any, fileName: String): String?

    /**
     * Διαγράφει ένα αρχείο από τη μνήμη της εφαρμογής με βάση το path του.
     * Χρησιμοποιείται για να μην μένουν "ορφανά" αντίγραφα αρχείων.
     */
    fun deleteFile(path: String?): Boolean
}