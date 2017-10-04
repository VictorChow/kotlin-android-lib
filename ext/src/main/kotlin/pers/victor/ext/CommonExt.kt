package pers.victor.ext

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Looper
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

inline val app: Application
    get() = Ext.ctx

inline val currentTimeMillis: Long
    get() = System.currentTimeMillis()

fun findColor(@ColorRes resId: Int) = ContextCompat.getColor(app, resId)

fun findDrawable(@DrawableRes resId: Int): Drawable? = ContextCompat.getDrawable(app, resId)

fun findColorStateList(@ColorRes resId: Int): ColorStateList? = ContextCompat.getColorStateList(app, resId)

fun inflate(@LayoutRes layoutId: Int, parent: ViewGroup?, attachToRoot: Boolean = false) = LayoutInflater.from(app).inflate(layoutId, parent, attachToRoot)!!

fun inflate(@LayoutRes layoutId: Int) = inflate(layoutId, null)

fun Context.dial(tel: String?) = startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel)))

fun Context.sms(phone: String?, body: String = "") {
    val smsToUri = Uri.parse("smsto:" + phone)
    val intent = Intent(Intent.ACTION_SENDTO, smsToUri)
    intent.putExtra("sms_body", body)
    startActivity(intent)
}

fun isMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()


fun <T> Boolean.yes(trueValue: () -> T) = TernaryOperator(trueValue, this)

class TernaryOperator<out T>(val trueValue: () -> T, val bool: Boolean)

fun <T> TernaryOperator<T>.no(falseValue: () -> T) = if (bool) trueValue() else falseValue()