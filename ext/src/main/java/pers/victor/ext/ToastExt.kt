package pers.victor.ext

import android.widget.Toast

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

private var toast: Toast? = null

fun toast(msg: Any, isShortToast: Boolean = true) {
    if (toast == null) {
        toast = Toast.makeText(app, msg.toString(), Toast.LENGTH_SHORT)
    } else {
        toast!!.setText(msg.toString())
    }
    toast!!.duration = if (isShortToast) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
    toast!!.show()
}