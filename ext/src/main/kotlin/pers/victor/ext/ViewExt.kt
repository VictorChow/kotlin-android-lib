package pers.victor.ext

import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.text.method.PasswordTransformationMethod
import android.text.method.ReplacementTransformationMethod
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import android.widget.EditText
import android.widget.TextView


/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

private val duration = 750L
private inline val interpolator: Interpolator
    get() = AccelerateDecelerateInterpolator()

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
    lp?.let {
        lp.height = value
        layoutParams = lp
    }
}

fun View.setWidth(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = value
        layoutParams = lp
    }
}

fun View.resize(width: Int, height: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}

inline val ViewGroup.children: List<View>
    get() = (0 until childCount).map { getChildAt(it) }

operator fun ViewGroup.get(index: Int): View {
    return getChildAt(index)
}

fun View.animateWidth(toValue: Int, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator): AnimatePropsWrapper {
    if (toValue == width || layoutParams == null) {
        return AnimatePropsWrapper(null)
    }
    return AnimatePropsWrapper(ValueAnimator().apply {
        setIntValues(width, toValue)
        setDuration(duration)
        setInterpolator(interpolator)
        addUpdateListener {
            val lp = layoutParams
            lp.width = it.animatedValue as Int
            layoutParams = lp
        }
        start()
    })
}

fun View.animateWidthBy(byValue: Int, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator)
        = animateWidth(width + byValue, duration, interpolator)

fun View.animateHeight(toValue: Int, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator): AnimatePropsWrapper {
    if (toValue == height || layoutParams == null) {
        return AnimatePropsWrapper(null)
    }
    return AnimatePropsWrapper(ValueAnimator().apply {
        setIntValues(height, toValue)
        setDuration(duration)
        setInterpolator(interpolator)
        addUpdateListener {
            val lp = layoutParams
            lp.height = it.animatedValue as Int
            layoutParams = lp
        }
        start()
    })
}

fun View.animateHeightBy(byValue: Int, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator)
        = animateHeight(height + byValue, duration, interpolator)

fun TextView.underLine() {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    paint.isAntiAlias = true
}

fun TextView.deleteLine() {
    paint.flags = paint.flags or Paint.STRIKE_THRU_TEXT_FLAG
    paint.isAntiAlias = true
}

fun TextView.bold(isBold: Boolean = true) {
    paint.isFakeBoldText = isBold
    paint.isAntiAlias = true
}

fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener { block(it as T) }

fun <T : View> T.longClick(block: (T) -> Boolean) = setOnLongClickListener { block(it as T) }

fun View.visiable() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

inline fun View.visiableIf(block: () -> Boolean) {
    if (visibility != View.VISIBLE && block()) {
        visibility = View.VISIBLE
    }
}

fun View.invisiable() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

inline fun View.invisiableIf(block: () -> Boolean) {
    if (visibility != View.INVISIBLE && block()) {
        visibility = View.INVISIBLE
    }
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

inline fun View.goneIf(block: () -> Boolean) {
    if (visibility != View.GONE && block()) {
        visibility = View.GONE
    }
}

fun View.animateX(toValue: Float, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator): AnimatePropsWrapper {
    if (toValue == translationX) {
        return AnimatePropsWrapper(null)
    }
    return AnimatePropsWrapper(ValueAnimator().apply {
        setFloatValues(translationX, toValue)
        setDuration(duration)
        setInterpolator(interpolator)
        addUpdateListener { this@animateX.translationX = it.animatedValue as Float }
        start()
    })
}

fun View.animateXBy(toValue: Float, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator)
        = animateX(translationX + toValue, duration, interpolator)

fun View.animateY(toValue: Float, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator): AnimatePropsWrapper {
    if (toValue == translationY) {
        return AnimatePropsWrapper(null)
    }
    return AnimatePropsWrapper(ValueAnimator().apply {
        setFloatValues(translationY, toValue)
        setDuration(duration)
        setInterpolator(interpolator)
        addUpdateListener { this@animateY.translationY = it.animatedValue as Float }
        start()
    })
}

fun View.animateYBy(toValue: Float, duration: Long = pers.victor.ext.duration, interpolator: Interpolator = pers.victor.ext.interpolator)
        = animateY(translationY + toValue, duration, interpolator)

var EditText.value: String
    get() = text.toString()
    set(value) = setText(value)

fun View.getBitmap(): Bitmap {
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bmp)
    draw(canvas)
    canvas.save()
    return bmp
}

fun EditText.uppercase() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = lower

        override fun getReplacement() = upper
    }
}

fun EditText.lowercase() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = upper

        override fun getReplacement() = lower
    }
}

fun EditText.passwordToggledVisible() {
    val selection = selectionStart
    transformationMethod = if (transformationMethod == null) PasswordTransformationMethod() else null
    setSelection(selection)
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isGone() = visibility == View.GONE

fun View.isInvisible() = visibility == View.INVISIBLE
