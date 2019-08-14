package pers.victor.ext

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by victor on 16-8-12. (ง •̀_•́)ง
 */
@Suppress("UNCHECKED_CAST")
object IntentData {
    fun putExtra(intent: Intent, key: String, value: Any) {
        when (value) {
            is Boolean -> intent.putExtra(key, value)
            is Byte -> intent.putExtra(key, value)
            is Char -> intent.putExtra(key, value)
            is Short -> intent.putExtra(key, value)
            is Int -> intent.putExtra(key, value)
            is Long -> intent.putExtra(key, value)
            is Float -> intent.putExtra(key, value)
            is Double -> intent.putExtra(key, value)
            is String -> intent.putExtra(key, value)
            is CharSequence -> intent.putExtra(key, value)
            is Parcelable -> intent.putExtra(key, value)
            is Serializable -> intent.putExtra(key, value)
            is BooleanArray -> intent.putExtra(key, value)
            is ByteArray -> intent.putExtra(key, value)
            is ShortArray -> intent.putExtra(key, value)
            is CharArray -> intent.putExtra(key, value)
            is LongArray -> intent.putExtra(key, value)
            is DoubleArray -> intent.putExtra(key, value)
            is FloatArray -> intent.putExtra(key, value)
            is IntArray -> intent.putExtra(key, value)
            is Bundle -> intent.putExtra(key, value)
            is Array<*> -> {
                if (value.isNotEmpty() && value[0] != null) {
                    when (value[0]) {
                        is Parcelable -> intent.putExtra(key, value as Array<out Parcelable>)
                        is CharSequence -> intent.putExtra(key, value as Array<out CharSequence>)
                        is String -> intent.putExtra(key, value as Array<out String>)
                    }
                }
            }
        }
    }
}