package pers.victor.ext

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * Created by Victor on 2017/9/21. (ง •̀_•́)ง
 */

fun File.copy(dest: File) {
    if (!dest.exists()) {
        dest.createNewFile()
    }
    val fi = FileInputStream(this)
    val fo = FileOutputStream(dest)
    val ic = fi.channel
    val oc = fo.channel
    ic.transferTo(0, ic.size(), oc)
    fi.close()
    fo.close()
    ic.close()
    oc.close()
}

fun File.move(dest: File) {
    copy(dest)
    delete()
}

fun File.copyDirectory(dest: File) {
    if (!dest.exists()) {
        dest.mkdirs()
    }
    val files = listFiles()
    files?.forEach {
        if (it.isFile) {
            it.copy(File("${dest.absolutePath}/${it.name}"))
        }
        if (it.isDirectory) {
            val dirSrc = File("$absolutePath/${it.name}")
            val dirDest = File("${dest.absolutePath}/${it.name}")
            dirSrc.copyDirectory(dirDest)
        }
    }
}

fun File.moveDirectory(dest: File) {
    copyDirectory(dest)
    deleteAll()
}

fun File.deleteAll() {
    if (isFile && exists()) {
        delete()
        return
    }
    if (isDirectory) {
        val files = listFiles()
        if (files == null || files.isEmpty()) {
            delete()
            return
        }
        files.forEach { it.deleteAll() }
        delete()
    }
}