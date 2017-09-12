package pers.victor.ext

/**
 * Created by Victor on 2017/8/21. (ง •̀_•́)ง
 */

val screenWidth: Int
    get() = app.resources.displayMetrics.widthPixels

val screenHeight: Int
    get() = app.resources.displayMetrics.heightPixels

val screenDensity: Float
    get() = app.resources.displayMetrics.density

val scaledDensity: Float
    get() = app.resources.displayMetrics.scaledDensity

fun dp2px(dp: Number) = (dp.toFloat() * app.resources.displayMetrics.density + 0.5f).toInt()

fun sp2px(sp: Number) = (sp.toFloat() * app.resources.displayMetrics.scaledDensity + 0.5f).toInt()

fun px2dp(px: Number) = (px.toFloat() / app.resources.displayMetrics.density + 0.5f).toInt()

fun px2sp(px: Number) = (px.toFloat() / app.resources.displayMetrics.scaledDensity + 0.5f).toInt()
