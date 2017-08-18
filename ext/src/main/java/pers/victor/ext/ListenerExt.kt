package pers.victor.ext

import android.animation.Animator
import android.support.v4.view.ViewPager
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */


fun Animator.addListener(init: AnimatorListenerWrapper.() -> Unit) {
    val wrapper = AnimatorListenerWrapper().apply { init() }
    addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
            wrapper.onRepeat?.invoke()
        }

        override fun onAnimationEnd(p0: Animator?) {
            wrapper.onEnd?.invoke()
        }

        override fun onAnimationCancel(p0: Animator?) {
            wrapper.onCancel?.invoke()
        }

        override fun onAnimationStart(p0: Animator?) {
            wrapper.onStart?.invoke()
        }

    })
}

fun Animator.addPauseListener(init: AnimatorPauseListenerWrapper.() -> Unit) {
    val wrapper = AnimatorPauseListenerWrapper().apply { init() }
    addPauseListener(object : Animator.AnimatorPauseListener {
        override fun onAnimationPause(p0: Animator?) {
            wrapper.onPause?.invoke()
        }

        override fun onAnimationResume(p0: Animator?) {
            wrapper.onResume?.invoke()
        }
    })
}

fun TextView.addTextChangedListener(init: TextWatcherWrapper.() -> Unit) {
    val wrapper = TextWatcherWrapper().apply { init() }
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            wrapper.after?.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            wrapper.before?.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            wrapper.on?.invoke(p0, p1, p2, p3)
        }

    })
}

fun ViewPager.addOnPageChangeListener(init: OnPageChangeListenerWrapper.() -> Unit) {
    val wrapper = OnPageChangeListenerWrapper().apply { init() }
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            wrapper.onPageScrollStateChanged?.invoke(state)
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            wrapper.onPageScrolled?.invoke(position, positionOffset, positionOffsetPixels)

        }

        override fun onPageSelected(position: Int) {
            wrapper.onPageSelected?.invoke(position)
        }

    })
}