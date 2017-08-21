package pers.victor.ext

import android.app.Application

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */
object Ext {
    internal var ctx: Application? = null

    fun with(ctx: Application) {
        this.ctx = ctx
    }
}