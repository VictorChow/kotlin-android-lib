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
    get() = extAppCtx!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

val alarmManager: AlarmManager
    get() = extAppCtx!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

val telephonyManager: TelephonyManager
    get() = extAppCtx!!.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

val activityManager: ActivityManager
    get() = extAppCtx!!.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

val notificationManager: NotificationManager
    get() = extAppCtx!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

val inputMethodManager: InputMethodManager
    get() = extAppCtx!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager