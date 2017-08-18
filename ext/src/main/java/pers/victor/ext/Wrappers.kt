package pers.victor.ext

import android.text.Editable

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

class AnimatorListenerWrapper {
    internal var onStart: (() -> Unit)? = null
    internal var onEnd: (() -> Unit)? = null
    internal var onCancel: (() -> Unit)? = null
    internal var onRepeat: (() -> Unit)? = null

    fun onStart(block: (() -> Unit)) {
        onStart = block
    }

    fun onEnd(block: (() -> Unit)) {
        onEnd = block
    }

    fun onCancel(block: (() -> Unit)) {
        onCancel = block
    }

    fun onRepeat(block: (() -> Unit)) {
        onRepeat = block
    }
}

class AnimatorPauseListenerWrapper {
    internal var onPause: (() -> Unit)? = null
    internal var onResume: (() -> Unit)? = null

    fun onPause(block: (() -> Unit)) {
        onPause = block
    }

    fun onResume(block: (() -> Unit)) {
        onResume = block
    }
}

class TextWatcherWrapper {
    internal var after: ((Editable) -> Unit)? = null
    internal var before: ((CharSequence, Int, Int, Int) -> Unit)? = null
    internal var on: ((CharSequence, Int, Int, Int) -> Unit)? = null

    fun after(block: (Editable) -> Unit) {
        after = block
    }

    fun before(block: (s: CharSequence, start: Int, count: Int, after: Int) -> Unit) {
        before = block
    }

    fun on(block: (s: CharSequence, start: Int, before: Int, count: Int) -> Unit) {
        on = block
    }
}

class OnPageChangeListenerWrapper {
    internal var onPageScrolled: ((Int, Float, Int) -> Unit)? = null
    internal var onPageSelected: ((Int) -> Unit)? = null
    internal var onPageScrollStateChanged: ((Int) -> Unit)? = null

    fun onPageScrolled(block: (position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit) {
        onPageScrolled = block
    }

    fun onPageSelected(block: (Int) -> Unit) {
        onPageSelected = block
    }

    fun onPageScrollStateChanged(block: (Int) -> Unit) {
        onPageScrollStateChanged = block
    }
}