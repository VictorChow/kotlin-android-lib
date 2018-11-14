package pers.victor.ext

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager
import kotlin.DeprecationLevel.WARNING


/**
 * Created by Victor on 2017/8/21. (ง •̀_•́)ง
 */

val displayMetrics = app.resources.displayMetrics!!

inline val screenWidth: Int
    get() = app.resources.displayMetrics.widthPixels

inline val screenHeight: Int
    get() = app.resources.displayMetrics.heightPixels

inline val screenDensity: Float
    get() = app.resources.displayMetrics.density

inline val scaledDensity: Float
    get() = app.resources.displayMetrics.scaledDensity

fun getStatusBarHeight(): Int {
    var result = 0
    val resourceId = app.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = app.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun getVirNavBarHeight(): Int {
    var height: Int
    val wm = (app.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
    val display = wm.defaultDisplay
    val p = Point()
    display.getSize(p)
    val screenHeight = Math.max(p.y, p.x)
    val dm = DisplayMetrics()
    val c: Class<*> = Class.forName("android.view.Display")
    val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
    method.invoke(display, dm)
    //横屏在右|竖屏在底
    height = Math.max(dm.heightPixels, dm.widthPixels) - screenHeight
    //横屏在底|竖屏在底
    if (height == 0) {
        height = Math.min(dm.heightPixels, dm.widthPixels) - Math.min(p.y, p.x)
    }
    return height
}

//ReplaceWith()目前不支持将方法转换字段，所以需要手动修改
@Deprecated("使用扩展属性更加直观, dp(360) -> 360.dp",level = WARNING)
fun dp2px(dp: Number) = (dp.toFloat() * displayMetrics.density + 0.5f).toInt()

@Deprecated("使用扩展属性更加直观, sp(360) -> 360.sp",level =  WARNING)
fun sp2px(sp: Number) = (sp.toFloat() * displayMetrics.scaledDensity + 0.5f).toInt()

@Deprecated("使用扩展属性更加直观, px2dp(360) -> 360.px2dp",level =  WARNING)
fun px2dp(px: Number) = (px.toFloat() / displayMetrics.density + 0.5f).toInt()

@Deprecated("使用扩展属性更加直观, px2sp(360) -> 360.px2sp",level =  WARNING)
fun px2sp(px: Number) = (px.toFloat() / displayMetrics.scaledDensity + 0.5f).toInt()
