package pers.victor.ext

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by Victor on 2017/9/12. (ง •̀_•́)ง
 */

inline fun <reified T : Activity> Fragment.goActivity() = startActivity(Intent(activity, T::class.java))

inline fun <reified T : Activity> Fragment.goActivity(requestCode: Int) = startActivityForResult(Intent(activity, T::class.java), requestCode)

inline fun <reified T : Service> Fragment.goService() = activity?.startService(Intent(activity, T::class.java))

inline fun <reified T : Service> Fragment.goService(sc: ServiceConnection, flags: Int = Context.BIND_AUTO_CREATE) = activity?.bindService(Intent(activity, T::class.java), sc, flags)

fun Fragment.hideInputMethod() {
    if (activity != null && activity!!.window.peekDecorView() != null) {
        inputMethodManager.hideSoftInputFromWindow(activity!!.window.peekDecorView().windowToken, 0)
    }
}

fun Fragment.showInputMethod(v: EditText) {
    v.requestFocus()
    inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_FORCED)
}

fun Fragment.finish() = activity?.finish()

