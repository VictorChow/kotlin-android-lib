package pers.victor.ext

/**
 * Created by Victor on 2017/8/21. (ง •̀_•́)ง
 */

val screenWidth: Int
    get() = Ext.ctx.resources.displayMetrics.widthPixels

val screenHeight: Int
    get() = Ext.ctx.resources.displayMetrics.heightPixels

val screenDensity: Float
    get() = Ext.ctx.resources.displayMetrics.density

val scaledDensity: Float
    get() = Ext.ctx.resources.displayMetrics.scaledDensity

fun dp2px(dp: Number) = (dp.toFloat() * Ext.ctx.resources.displayMetrics.density + 0.5f).toInt()

fun sp2px(sp: Number) = (sp.toFloat() * Ext.ctx.resources.displayMetrics.scaledDensity + 0.5f).toInt()

fun px2dp(px: Number) = (px.toFloat() / Ext.ctx.resources.displayMetrics.density + 0.5f).toInt()

fun px2sp(px: Number) = (px.toFloat() / Ext.ctx.resources.displayMetrics.scaledDensity + 0.5f).toInt()
