package pers.victor.ext

import android.app.Application

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */
object Ext {
    lateinit var ctx: Application

    fun with(ctx: Application) {
        this.ctx = ctx
    }
}