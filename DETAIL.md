### Usage

```kotlin
//初始化
Ext.with(application)
```

### ViewExt

```kotlin
//设置padding
fun View.setPaddingLeft(value: Int) 
fun View.setPaddingRight(value: Int)
fun View.setPaddingTop(value: Int)
fun View.setPaddingBottom(value: Int)
fun View.setPaddingStart(value: Int)
fun View.setPaddingEnd(value: Int)
fun View.setPaddingHorizontal(value: Int)
fun View.setPaddingVertical(value: Int)

//设置宽高
fun View.setWidth(value: Int)
fun View.setHeight(value: Int)
fun View.resize(width: Int, height: Int)

//设置宽高(动画)
fun View.animateWidth(toValue: Int, duration: Long, interpolator: Interpolator)
fun View.animateWidthBy(toValue: Int, duration: Long, interpolator: Interpolator)
fun View.animateHeight(toValue: Int, duration: Long, interpolator: Interpolator)
fun View.animateHeightBy(toValue: Int, duration: Long, interpolator: Interpolator)

//移动
fun View.animateX(toValue: Int, duration: Long, interpolator: Interpolator)
fun View.animateXBy(toValue: Int, duration: Long, interpolator: Interpolator)
fun View.animateY(toValue: Int, duration: Long, interpolator: Interpolator)
fun View.animateYBy(toValue: Int, duration: Long, interpolator: Interpolator)

//ViewGroup子View
val ViewGroup.children: List<View>

//ViewGroup子View.getChildAt(index)
//val v = ViewGroup[index]
operator fun ViewGroup.get(index: Int)


//下划线
fun TextView.underLine()
//中划线
fun TextView.deleteLine()
//加粗
fun TextView.bold(b: Boolean)

//setText getText
var EditText.value: String
//所有字母大写
fun EditText.uppercase()
//所有字母小写
fun EditText.lowercase()
//显示、隐藏密码
fun EditText.passwordToggledVisible()

//点击, 调用时lambda里的it为具体View类型
fun <T : View> T.click(block: (T) -> Unit) 
fun <T : View> T.longClick(block: (T) -> Boolean)

//显示
fun View.visiable()
fun View.invisiable()
fun View.gone()

fun View.isVisible(): Boolean
fun View.isInvisible(): Boolean
fun View.isGone(): Boolean

fun View.visiableIf(block: () -> Boolean) 
fun View.invisiableIf(block: () -> Boolean) 
fun View.goneIf(block: () -> Boolean) 

//获取view的bitmap
fun View.getBitmap(): Bitmap
```

### CommonExt

```kotlin
val app: Application
val currentTimeMillis: Long

//强行三目运算符 yes no
val value = bool.yes { "true value" }.no { "false value" }
val value = bool yes { "true value" } no { "false value" }

//内部使用ContextCompat
fun findColor(@ColorRes resId: Int) 
fun findDrawable(@DrawableRes resId: Int)
fun findColorStateList(@ColorRes resId: Int)

fun inflate(@LayoutRes layoutId: Int, parent: ViewGroup?, attachToRoot: Boolean = false)
fun inflate(@LayoutRes layoutId: Int)

//跳转到拨号界面
fun Context.dial(tel: String?)
//跳转到短信界面
fun Context.sms(phone: String?, body: String)
//是否在主线程
fun isMainThread()
//是否连接网络
fun isNetworkConnected(): Boolean
```

### DisplayExt

```kotlin
//屏幕尺寸、密度
val screenWidth: Int
val screenHeight: Int
val screenDensity: Float
val scaledDensity: Float

fun dp2px(dp: Number)
fun sp2px(sp: Number)
fun px2dp(px: Number)
fun px2sp(px: Number)
```

### DateTimeExt

```kotlin
//格式化日期
fun Long.date(pattern: String = "yyyy-MM-dd HH:mm:ss")
fun Long.year()
fun Long.month()
fun Long.day()
fun Long.hour()
fun Long.minute()
fun Long.second()
fun Long.week()
fun Long.dateOnly(split: String)
fun Long.timeOnly(split: String)

//一年第几天
fun Long.dayOfYear()
//一年第几周
fun Long.weekOfYear()
//获取星座
fun Long.constellation()
//是否闰年
fun Int.isLeapYear()
```

### StringExt

```kotlin
fun String.toast()
fun String.md5()
fun String.sha1()

//是否是身份证
fun String.isIdcard()
//是否是手机号
fun String.isPhone()
//是否是邮箱
fun String.isEmail()
//是否是纯数字
fun String.isNumeric()
//不考虑大小写比较
fun String.equalsIgnoreCase(other: String)
```

### ListenerExt

```kotlin
fun Animator.addListener {
    onStart { }
    onCancel { }
    onEnd { }
    onRepeat { }
}

fun Animator.addPauseListener {
    onPause { }
    onResume { }
}

fun EditText.addTextChangedListener {
    before { s, start, count, after ->  }
    on { s, start, before, count ->  }
    after { }
}

fun ViewPager.addOnPageChangeListener {
    onPageScrollStateChanged {  }
    onPageSelected { }
    onPageScrolled { position, positionOffset, positionOffsetPixels ->  }
}
```

### ManagerExt

```kotlin
//直接调用
val connectivityManager
val alarmManager
val telephonyManager
val activityManager
val notificationManager
val appWidgetManager
val inputMethodManager
val clipboardManager
val bluetoothManager
val audioManager
val batteryManager
val cameraManager
val vibrator
```

### SharedPreferencesExt

```kotlin
fun spSetInt(key: String, value: Int)
fun spGetInt(key: String, defaultValue: Int = 0)
fun spSetLong(key: String, value: Long)
fun spGetLong(key: String, defaultValue: Long = 0L)
fun spSetFloat(key: String, value: Float)
fun spGetFloat(key: String, defaultValue: Float = 0f)
fun spSetBoolean(key: String, value: Boolean)
fun spGetBoolean(key: String, defaultValue: Boolean = false)
fun spSetString(key: String, value: String)
fun spGetString(key: String, defaultValue: String = "")
fun spRemove(key: String)
fun spClearAll()
```

### BitmapExt

```kotlin
//bitmap转base64
fun Bitmap.toBase64(): String
//bitmap调整大小
fun Bitmap.resize(w: Number, h: Number): Bitmap
//保存bitmap到文件
fun Bitmap.saveFile(path: String)
//bitmap转byte[]
fun Bitmap.toByteArray(): ByteArray 
```

### FileExt

```kotlin
//复制文件
fun File.copy(dest: File)
//移动文件
fun File.move(dest: File)
//复制文件夹
fun File.copyDirectory(dest: File)
//移动文件夹
fun File.moveDirectory(dest: File)
//删除文件夹及其下所有文件
fun File.deleteAll()

fun File.md5()
fun File.sha1()

//File转byte[]
fun File.toByteArray(): ByteArray 
```

### ToastExt

```kotlin
fun toast(msg: Any, isShortToast: Boolean = true) 
```

### ActivityExt

```kotlin
fun Activity.goActivity<T>()
fun Activity.goActivity<T>(requestCode: Int)

fun Activity.goService<T>()
fun Activity.goService<T>(sc: ServiceConnection, flags: Int)

fun Activity.hideInputMethod()
fun Activity.showInputMethod(v: EditText)

//清除window背景
fun Activity.clearWindowBackground()
fun Activity.steepStatusBar()

fun AppCompatActivity.addFragments(fragments: List<Fragment>, containerId: Int)
fun AppCompatActivity.showFragment(fragment: Fragment)
fun AppCompatActivity.hideFragment(fragment: Fragment)
```

### FragmentExt (support.v4)

```kotlin
fun Fragment.goActivity<T>()
fun Fragment.goActivity<T>(requestCode: Int)

fun Fragment.goService<T>()
fun Fragment.goService<T>(sc: ServiceConnection, flags: Int)

fun Fragment.hideInputMethod()
fun Fragment.showInputMethod(v: EditText)

//finish所在的Activity
fun Fragment.finish()
```

### ByteArrayExt

```kotlin
//保存byte[]到文件
fun ByteArray.saveFile(path: String)
//byte[]转Bitmap
fun ByteArray.toBitmap(opts: BitmapFactory.Options): Bitmap
```

### ActivityMgr

```kotlin
//建议放在BaseActivity里，onCreate()里ActivityMgr.add，onDestroy()里ActivityMgr.remove
fun add(activity: Activity)
fun remove(activity: Activity)
fun removeAll()
fun current(): Activity?
fun findFirst(clazz: KClass<T>): T?
fun findLast(clazz: KClass<T>): T?
fun find(clazz: KClass<T>): List<T>
fun finishFirst(clazz: KClass<*>)
fun finishLast(clazz: KClass<*>)
fun finish(clazz: KClass<*>)
fun finishExcept(vararg clazz: KClass<*>)
fun finishAll()
```

### ApiExt

```kotlin
// aboveApi(20) { view.elevation = 10f }
fun aboveApi(api: Int, included: Boolean = false, block: () -> Unit)
fun belowApi(api: Int, included: Boolean = false, block: () -> Unit)
```
