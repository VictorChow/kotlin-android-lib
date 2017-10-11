package pers.victor.ext

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.channels.FileChannel
import java.security.MessageDigest


/**
 * Created by Victor on 2017/9/21. (ง •̀_•́)ง
 */

fun File.copy(dest: File) {
    var fi: FileInputStream? = null
    var fo: FileOutputStream? = null
    var ic: FileChannel? = null
    var oc: FileChannel? = null
    try {
        if (!dest.exists()) {
            dest.createNewFile()
        }
        fi = FileInputStream(this)
        fo = FileOutputStream(dest)
        ic = fi.channel
        oc = fo.channel
        ic.transferTo(0, ic.size(), oc)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        fi?.close()
        fo?.close()
        ic?.close()
        oc?.close()
    }
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

fun File.md5(): String? {
    if (!this.isFile) {
        return null
    }
    return encryptFile(this, "MD5")
}

fun File.sha1(): String? {
    if (!this.isFile) {
        return null
    }
    return encryptFile(this, "SHA-1")
}

private fun encryptFile(file: File, type: String): String {
    val digest: MessageDigest = MessageDigest.getInstance(type)
    val input = FileInputStream(file)
    val buffer = ByteArray(1024)
    var len = input.read(buffer, 0, 1024)
    while (len != -1) {
        digest.update(buffer, 0, len)
        len = input.read(buffer, 0, 1024)
    }
    input.close()
    return bytes2Hex(digest.digest())
}

fun File.toByteArray(): ByteArray {
    val bos = ByteArrayOutputStream(this.length().toInt())
    val input = FileInputStream(this)
    val size = 1024
    val buffer = ByteArray(size)
    var len = input.read(buffer, 0, size)
    while (len != -1) {
        bos.write(buffer, 0, len)
        len = input.read(buffer, 0, size)
    }
    input.close()
    bos.close()
    return bos.toByteArray()
}