package pers.victor.ext

import android.os.Build

/**
 * Created by Victor on 2017/8/23. (ง •̀_•́)ง
 */

inline fun aboveApi(api: Int, included: Boolean = false, block: () -> Unit) {
    if (Build.VERSION.SDK_INT > if (included) api - 1 else api) {
        block()
    }
}

inline fun belowApi(api: Int, included: Boolean = false, block: () -> Unit) {
    if (Build.VERSION.SDK_INT < if (included) api + 1 else api) {
        block()
    }
}

fun aboveAndroid6(): Boolean = Build.VERSION.SDK_INT >= 23
fun aboveAndroid7(): Boolean = Build.VERSION.SDK_INT >= 24
fun aboveAndroid7_1(): Boolean = Build.VERSION.SDK_INT >= 25
fun aboveAndroid8(): Boolean = Build.VERSION.SDK_INT >= 26
fun aboveAndroid8_1(): Boolean = Build.VERSION.SDK_INT >= 27
fun aboveAndroid9(): Boolean = Build.VERSION.SDK_INT >= 28
fun aboveAndroid10(): Boolean = Build.VERSION.SDK_INT >= 29