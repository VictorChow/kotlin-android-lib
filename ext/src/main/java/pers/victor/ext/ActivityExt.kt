package pers.victor.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Build
import android.view.WindowManager
import android.widget.EditText

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

fun Activity.hideInputMethod() {
    window.peekDecorView()?.let {
        inputMethodManager.hideSoftInputFromWindow(window.peekDecorView().windowToken, 0)
    }
}

fun Activity.showInputMethod(et: EditText) = inputMethodManager.showSoftInput(et, 0)

fun Activity.dial(tel: String?) = startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel)))

fun Activity.sms(phone: String?, body: String = "") {
    val smsToUri = Uri.parse("smsto:" + phone)
    val intent = Intent(Intent.ACTION_SENDTO, smsToUri)
    intent.putExtra("sms_body", body)
    startActivity(intent)
}

fun Activity.clearWindowBackground() = window.setBackgroundDrawable(null)

fun Activity.steepStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }
}

inline fun <reified T> Activity.startActivity() = startActivity(Intent(this, T::class.java))

inline fun <reified T> Activity.startActivityForResult(requestCode: Int)
        = startActivityForResult(Intent(this, T::class.java), requestCode)

inline fun <reified T> Activity.startService() = startService(Intent(this, T::class.java))

inline fun <reified T> Activity.bindService(sc: ServiceConnection, flags: Int = Context.BIND_AUTO_CREATE)
        = bindService(Intent(this, T::class.java), sc, flags)


