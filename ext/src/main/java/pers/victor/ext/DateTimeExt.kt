package pers.victor.ext

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Victor on 2017/8/21. (ง •̀_•́)ง
 */

private enum class DateExpr {
    YEAR, MONTH, DAY,
    HOUR, MINUTE, SECOND,
    WEEK, DAY_YEAR, WEEK_YEAR,
    CONSTELLATION
}

fun Long.date(pattern: String = "yyyy-MM-dd HH:mm:ss"): String? = SimpleDateFormat(pattern, Locale.CHINA).format(this)

fun Long.year() = getData(this, DateExpr.YEAR)

fun Long.month() = getData(this, DateExpr.MONTH)

fun Long.day() = getData(this, DateExpr.DAY)

fun Long.week() = getData(this, DateExpr.WEEK)

fun Long.hour() = getData(this, DateExpr.HOUR)

fun Long.minute() = getData(this, DateExpr.MINUTE)

fun Long.second() = getData(this, DateExpr.SECOND)

fun Long.dayOfYear() = getData(this, DateExpr.DAY_YEAR)

fun Long.weekOfYear() = getData(this, DateExpr.WEEK_YEAR)

fun Long.constellation() = getData(this, DateExpr.CONSTELLATION)

fun Long.dateOnly(split: String = "-") = "${year()}$split${month()}$split${day()}"

fun Long.timeOnly(split: String = ":") = "${hour()}$split${minute()}$split${second()}"

fun Int.isLeapYear() = (this % 4 == 0) && (this % 100 != 0) || (this % 400 == 0)

private fun getData(timeMillis: Long, expr: DateExpr): String {
    val cal = Calendar.getInstance()
    cal.time = Date(timeMillis)
    return when (expr) {
        DateExpr.YEAR -> cal[Calendar.YEAR].toString()
        DateExpr.MONTH -> (cal[Calendar.MONTH] + 1).toString().prefix0()
        DateExpr.DAY -> cal[Calendar.DAY_OF_MONTH].toString().prefix0()
        DateExpr.WEEK -> {
            val week = arrayOf("未知", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")
            week[cal.get(Calendar.DAY_OF_WEEK)]
        }
        DateExpr.HOUR -> cal[Calendar.HOUR_OF_DAY].toString().prefix0()
        DateExpr.MINUTE -> cal[Calendar.MINUTE].toString().prefix0()
        DateExpr.SECOND -> cal[Calendar.SECOND].toString().prefix0()
        DateExpr.DAY_YEAR -> cal[Calendar.DAY_OF_YEAR].toString()
        DateExpr.WEEK_YEAR -> cal[Calendar.WEEK_OF_YEAR].toString()
        DateExpr.CONSTELLATION -> getConstellations(timeMillis.month().toInt(), timeMillis.day().toInt())
    }
}

private fun getConstellations(month: Int, day: Int): String {
    val constellations = arrayOf(arrayOf("摩羯座", "水瓶座"), arrayOf("水瓶座", "双鱼座"), arrayOf("双鱼座", "白羊座"), arrayOf("白羊座", "金牛座"), arrayOf("金牛座", "双子座"), arrayOf("双子座", "巨蟹座"), arrayOf("巨蟹座", "狮子座"), arrayOf("狮子座", "处女座"), arrayOf("处女座", "天秤座"), arrayOf("天秤座", "天蝎座"), arrayOf("天蝎座", "射手座"), arrayOf("射手座", "摩羯座"))
    val dateSplit = intArrayOf(20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22)
    val split = dateSplit[month - 1]
    val constellation = constellations[month - 1]
    return if (day >= split) constellation[1] else constellation[0]
}

private fun String.prefix0() = if (length == 1) "0$this" else this