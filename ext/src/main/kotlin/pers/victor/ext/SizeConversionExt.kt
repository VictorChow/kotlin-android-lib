package pers.victor.ext

import android.content.res.Resources
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.COMPLEX_UNIT_SP

private val metrics = Resources.getSystem().displayMetrics

/**
 * 正常编码中一般只会用到 [dp]/[sp] 和 [px] ;
 * 其中[dp]/[sp] 会根据系统分辨率将输入的dp/sp值转换为对应的px
 * 而[px]只是返回自身，目的是表明自己是px值
 */
val Float.dp: Float      // [xxhdpi](360 -> 1080)
    get() = TypedValue.applyDimension(COMPLEX_UNIT_DIP, this, metrics)

val Int.dp: Int      // [xxhdpi](360 -> 1080)
    get() = TypedValue.applyDimension(COMPLEX_UNIT_DIP, this.toFloat(), metrics).toInt()

val Float.sp: Float      // [xxhdpi](360 -> 1080)
    get() = TypedValue.applyDimension(COMPLEX_UNIT_SP, this, metrics)

val Int.sp: Int      // [xxhdpi](360 -> 1080)
    get() = TypedValue.applyDimension(COMPLEX_UNIT_SP, this.toFloat(), metrics).toInt()

val Number.px: Number      // [xxhdpi](360 -> 360)
    get() = this

/**
 * 在(可能存在的?)某些特殊情况会需要将px值转换为对应的dp/sp
 * 对应方法[Number.px2dp]/[Number.px2sp]
 */
val Number.px2dp: Int       // [xxhdpi](360 -> 120)
    get() = (this.toFloat() / metrics.density).toInt()

val Number.px2sp: Int       // [xxhdpi](360 -> 120)
    get() = (this.toFloat() / metrics.scaledDensity).toInt()