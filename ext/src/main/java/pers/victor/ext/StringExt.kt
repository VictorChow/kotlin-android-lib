package pers.victor.ext

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * Created by Victor on 2017/8/21. (ง •̀_•́)ง
 */

fun String.toast(isShortToast: Boolean = true) = toast(this, isShortToast)

fun String.md5() = encrypt(this, "MD5")

fun String.sha1() = encrypt(this, "SHA-1")

fun String.isIdcard(): Boolean {
    val p18 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]\$"
    val p15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]\$"
    return matches(p18.toRegex()) || matches(p15.toRegex())
}

fun String.isPhone(): Boolean {
    val p = "^1(3|4|5|7|8)\\d{9}\$"
    return matches(p.toRegex())
}

fun String.isEmail(): Boolean {
    val p = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)\$"
    return matches(p.toRegex())
}

fun String.equalsIgnoreCase(other: String) = this.toLowerCase().contentEquals(other.toLowerCase())

private fun encrypt(string: String?, type: String): String {
    if (string.isNullOrEmpty()) {
        return ""
    }
    val md5: MessageDigest
    return try {
        md5 = MessageDigest.getInstance(type)
        val bytes = md5.digest(string!!.toByteArray())
        bytes2Hex(bytes)
    } catch (e: NoSuchAlgorithmException) {
        ""
    }
}

private fun bytes2Hex(bts: ByteArray): String {
    var des = ""
    var tmp: String
    for (i in bts.indices) {
        tmp = Integer.toHexString(bts[i].toInt() and 0xFF)
        if (tmp.length == 1) {
            des += "0"
        }
        des += tmp
    }
    return des
}
