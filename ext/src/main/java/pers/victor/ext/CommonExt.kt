package pers.victor.ext

import android.annotation.SuppressLint
import android.app.Application
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

@SuppressLint("StaticFieldLeak")
var extAppCtx: Application? = null

fun findColor(@ColorRes resId: Int) = ContextCompat.getColor(extAppCtx, resId)

fun findDrawable(@DrawableRes resId: Int): Drawable? = ContextCompat.getDrawable(extAppCtx, resId)

fun findColorStateList(@ColorRes resId: Int): ColorStateList? = ContextCompat.getColorStateList(extAppCtx, resId)

fun inflate(@LayoutRes layoutId: Int, parent: ViewGroup?, attachToRoot: Boolean = false) = LayoutInflater.from(extAppCtx).inflate(layoutId, parent, attachToRoot)!!

fun inflate(@LayoutRes layoutId: Int) = inflate(layoutId, null)

fun dp2px(dp: Number) = (dp.toFloat() * extAppCtx!!.resources.displayMetrics.density + 0.5f).toInt()

fun sp2px(sp: Number) = (sp.toFloat() * extAppCtx!!.resources.displayMetrics.scaledDensity + 0.5f).toInt()