package pers.victor.ext

import android.graphics.Typeface
import android.support.annotation.ColorRes
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

fun spannableSize(text: String, textSize: Int, isDip: Boolean, start: Int, end: Int): SpannableString {
    val sp = SpannableString(text)
    sp.setSpan(AbsoluteSizeSpan(textSize, isDip), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    return sp
}

fun spannableBold(text: String, start: Int, end: Int): SpannableString {
    val sp = SpannableString(text)
    sp.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    return sp
}

fun spannableColor(text: String, @ColorRes colorId: Int, start: Int, end: Int): SpannableString {
    val sp = SpannableString(text)
    sp.setSpan(ForegroundColorSpan(findColor(colorId)), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    return sp
}
