package com.example.uhunt.galleryPickers

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun getFileFromUri(context: Context, uri: Uri): File? {
    val inputStream = context.contentResolver.openInputStream(uri)
    val file = createTempFile(context)

    try {
        inputStream?.let {
            val outputStream = FileOutputStream(file)
            val buffer = ByteArray(4 * 1024) // 4 KB buffer size
            var read: Int
            while (inputStream.read(buffer).also { read = it } != -1) {
                outputStream.write(buffer, 0, read)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
            return file
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return null
}

private fun createTempFile(context: Context): File {
    val fileName = "temp_image.jpg"
    return File(context.cacheDir, fileName)
}
