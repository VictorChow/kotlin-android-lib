package pers.victor.ext

import android.app.Activity
import android.app.Fragment
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by Victor on 2017/9/12. (ง •̀_•́)ง
 */

inline fun <reified T : Activity> Activity.goActivity() = startActivity(Intent(this, T::class.java))

inline fun <reified T : Activity> Activity.goActivity(requestCode: Int) = startActivityForResult(Intent(this, T::class.java), requestCode)

inline fun <reified T : Service> Activity.goService() = startService(Intent(this, T::class.java))

inline fun <reified T : Service> Activity.goService(sc: ServiceConnection, flags: Int = Context.BIND_AUTO_CREATE) = bindService(Intent(this, T::class.java), sc, flags)

fun Activity.hideInputMethod() = window.peekDecorView()?.let { inputMethodManager.hideSoftInputFromWindow(window.peekDecorView().windowToken, 0) }

fun Activity.showInputMethod(v: EditText) {
    v.requestFocus()
    inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_FORCED)
}

fun Activity.clearWindowBackground() = window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

fun Activity.steepStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }
}

fun AppCompatActivity.addFragments(fragments: List<Fragment>, containerId: Int) {
    fragments.forEach {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(containerId, it)
        ft.commitAllowingStateLoss()
    }
}

fun AppCompatActivity.showFragment(fragment: Fragment) {
    val ft = supportFragmentManager.beginTransaction()
    ft.show(fragment)
    ft.commitAllowingStateLoss()
}

fun AppCompatActivity.hideFragment(fragment: Fragment) {
    val ft = supportFragmentManager.beginTransaction()
    ft.hide(fragment)
    ft.commitAllowingStateLoss()
}