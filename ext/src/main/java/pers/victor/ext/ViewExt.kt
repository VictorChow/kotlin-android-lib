package pers.victor.ext

import android.animation.ValueAnimator
import android.graphics.Paint
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import android.widget.TextView

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

fun View.setPaddingLeft(value: Int) = setPadding(value, paddingTop, paddingRight, paddingBottom)

fun View.setPaddingRight(value: Int) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

fun View.setPaddingTop(value: Int) = setPaddingRelative(paddingStart, value, paddingEnd, paddingBottom)

fun View.setPaddingBottom(value: Int) = setPaddingRelative(paddingStart, paddingTop, paddingEnd, value)

fun View.setPaddingStart(value: Int) = setPaddingRelative(value, paddingTop, paddingEnd, paddingBottom)

fun View.setPaddingEnd(value: Int) = setPaddingRelative(paddingStart, paddingTop, value, paddingBottom)

fun View.setPaddingHorizontal(value: Int) = setPaddingRelative(value, paddingTop, value, paddingBottom)

fun View.setPaddingVertical(value: Int) = setPaddingRelative(paddingStart, value, paddingEnd, value)

fun View.setHeight(value: Int) {
    val lp = layoutParams
    if (lp != null) {
        lp.height = value
        layoutParams = lp
    }
}

fun View.setWidth(value: Int) {
    val lp = layoutParams
    if (lp != null) {
        lp.width = value
        layoutParams = lp
    }
}

fun View.resize(width: Int, height: Int) {
    val lp = layoutParams
    if (lp != null) {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}

val ViewGroup.children: List<View>
    get() = (0 until childCount).map { getChildAt(it) }

fun View.animateWidth(toValue: Int, duration: Long = 1000, interpolator: Interpolator = AccelerateDecelerateInterpolator()) {
    if (toValue == width) {
        return
    }
    ValueAnimator().apply {
        setIntValues(width, toValue)
        setDuration(duration)
        setInterpolator(interpolator)
        addUpdateListener {
            val lp = layoutParams
            if (lp != null) {
                lp.width = it.animatedValue as Int
                layoutParams = lp
            }
        }
    }.start()
}

fun View.animateWidthBy(byValue: Int, duration: Long = 1000, interpolator: Interpolator = AccelerateDecelerateInterpolator())
        = animateWidth(width + byValue, duration, interpolator)

fun View.animateHeight(toValue: Int, duration: Long = 1000, interpolator: Interpolator = AccelerateDecelerateInterpolator()) {
    if (toValue == height) {
        return
    }
    ValueAnimator().apply {
        setIntValues(height, toValue)
        setDuration(duration)
        setInterpolator(interpolator)
        addUpdateListener {
            val lp = layoutParams
            if (lp != null) {
                lp.height = it.animatedValue as Int
                layoutParams = lp
            }
        }
    }.start()
}

fun View.animateHeightBy(byValue: Int, duration: Long = 1000, interpolator: Interpolator = AccelerateDecelerateInterpolator())
        = animateHeight(height + byValue, duration, interpolator)

fun TextView.underLine() {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    paint.isAntiAlias = true
}

fun TextView.deleteLine() {
    paint.flags = paint.flags or Paint.STRIKE_THRU_TEXT_FLAG
    paint.isAntiAlias = true
}

fun TextView.bold() {
    paint.isFakeBoldText = true
    paint.isAntiAlias = true
}


