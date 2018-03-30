package pers.victor.ext

/**
 * 正常编码中一般只会用到 [dp]/[sp] 和 [px] ;
 * 其中[dp]/[sp] 会根据系统分辨率将输入的dp/sp值转换为对应的px
 * 而[px]只是返回自身，目的是表明自己是px值
 */

val Number.dp: Int
    get() = dp2px(this)     // [xxhdpi](360 -> 1080)

val Number.sp: Int
    get() = sp2px(this)     // [xxhdpi](360 -> 1080)

val Number.px: Int
    get() = this.toInt()     // [xxhdpi](360 -> 360)

/**
 * 在(可能存在的?)某些特殊情况会需要将px值转换为对应的dp/sp
 * 对应方法[px2dp]/[px2sp]
 */
val Number.px2dp: Int
    get() = px2dp(this)     // [xxhdpi](360 -> 120)

val Number.px2sp: Int
    get() = px2sp(this)     // [xxhdpi](360 -> 120)