package pers.victor.ext

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.NotificationManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.media.AudioManager
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.telephony.TelephonyManager
import android.view.inputmethod.InputMethodManager

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

inline val connectivityManager: ConnectivityManager
    get() = Ext.ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

inline val alarmManager: AlarmManager
    get() = Ext.ctx.getSystemService(Context.ALARM_SERVICE) as AlarmManager

inline val telephonyManager: TelephonyManager
    get() = Ext.ctx.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

inline val activityManager: ActivityManager
    get() = Ext.ctx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

inline val notificationManager: NotificationManager
    get() = Ext.ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

inline val appWidgetManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = Ext.ctx.getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

inline val inputMethodManager: InputMethodManager
    get() = Ext.ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

inline val clipboardManager
    get() = Ext.ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

inline val bluetoothManager: BluetoothManager
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    get() = Ext.ctx.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

inline val audioManager
    get() = Ext.ctx.getSystemService(Context.AUDIO_SERVICE) as AudioManager

inline val batteryManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = Ext.ctx.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
