package pers.victor.ext

import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream

/**
 * Created by Victor on 2017/10/11. (ง •̀_•́)ง
 */

fun ByteArray.saveFile(path: String) {
    val file = File(path)
    if (!file.exists()) {
        file.createNewFile()
    }
    val output = FileOutputStream(file)
    output.write(this)
    output.flush()
    output.close()
}

fun ByteArray.toBitmap(opts: BitmapFactory.Options? = null) = BitmapFactory.decodeByteArray(this, 0, size, opts)