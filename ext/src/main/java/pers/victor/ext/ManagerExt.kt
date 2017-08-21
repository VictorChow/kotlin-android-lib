package pers.victor.ext

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import android.view.inputmethod.InputMethodManager

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

val connectivityManager: ConnectivityManager
    get() = Ext.ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

val alarmManager: AlarmManager
    get() = Ext.ctx.getSystemService(Context.ALARM_SERVICE) as AlarmManager

val telephonyManager: TelephonyManager
    get() = Ext.ctx.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

val activityManager: ActivityManager
    get() = Ext.ctx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

val notificationManager: NotificationManager
    get() = Ext.ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

val inputMethodManager: InputMethodManager
    get() = Ext.ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager