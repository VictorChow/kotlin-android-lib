package pers.victor.ext

fun Number.dp(): Int {
    return px2dp(this)
}

fun Number.px(): Int {
    return dp2px(this)
}

fun Number.sp(): Int {
    return px2sp(this)
}