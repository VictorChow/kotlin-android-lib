package pers.victor.ext

import android.preference.PreferenceManager

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

private val sp = PreferenceManager.getDefaultSharedPreferences(extAppCtx)

fun spSetInt(key: String, value: Int) = sp.edit().putInt(key, value).apply()

fun spGetInt(key: String, defaultValue: Int = 0) = sp.getInt(key, defaultValue)

fun spSetLong(key: String, value: Long) = sp.edit().putLong(key, value).apply()

fun spGetLong(key: String, defaultValue: Long = 0L) = sp.getLong(key, defaultValue)

fun spSetFloat(key: String, value: Float) = sp.edit().putFloat(key, value).apply()

fun spGetFloat(key: String, defaultValue: Float = 0f) = sp.getFloat(key, defaultValue)

fun spSetBoolean(key: String, value: Boolean) = sp.edit().putBoolean(key, value).apply()

fun spGetBoolean(key: String, defaultValue: Boolean = false) = sp.getBoolean(key, defaultValue)

fun spSetString(key: String, value: String) = sp.edit().putString(key, value).apply()

fun spGetString(key: String, defaultValue: String = "") = sp.getString(key, defaultValue)!!

fun spRemove(key: String) = sp.edit().remove(key).apply()

fun spClearAll() = sp.edit().clear().apply()