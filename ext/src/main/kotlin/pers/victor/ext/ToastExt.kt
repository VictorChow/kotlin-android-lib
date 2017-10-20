package pers.victor.ext

import android.annotation.SuppressLint
import android.widget.Toast

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

private var toast: Toast? = null

@SuppressLint("ShowToast")
fun toast(msg: Any?, isShort: Boolean = true) {
    msg?.let {
        if (toast == null) {
            toast = Toast.makeText(app, msg.toString(), Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg.toString())
        }
        toast!!.duration = if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
        toast!!.show()
    }
}
