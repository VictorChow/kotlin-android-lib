package pers.victor.ext

/**
 * 正常编码中一般只会用到 Number.dp()/sp() 和 Number.px() ;
 * 其中Number.dp()/sp()会根据系统分辨率将输入的px值转换为对应的px
 * 而Number.px()只是返回自身，目的是表明自己是px值
 */

fun Number.dp() = dp2px(this)        // [xxhdpi](360 -> 1080)

fun Number.sp() = sp2px(this)        // [xxhdpi](360 -> 1080)

fun Number.px() = this.toInt()           // [xxhdpi](360 -> 360)


fun Number.px2dp() = px2dp(this)     // [xxhdpi](360 -> 120)

fun Number.px2sp() = px2sp(this)     // [xxhdpi](360 -> 120)