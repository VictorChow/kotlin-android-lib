# KotlinAndroidLib [![](https://jitpack.io/v/VictorChow/kotlin-android-lib.svg)](https://jitpack.io/#VictorChow/kotlin-android-lib)

一些Android开发的扩展。

[[点这查看所有支持的扩展API(readmore)]](./DETAIL.md)

## Usage

```kotlin
//初始化
Ext.with(application)
```

## Gradle

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy
//依赖项
//org.jetbrains.kotlin:kotlin-stdlib-jre
//com.android.support:appcompat-v7

dependencies {
    compile 'com.github.VictorChow:kotlin-android-lib:1.2.2'
}
```

## Brief

### ViewExt

```kotlin
//设置宽高
fun View.setWidth(value: Int)
fun View.setHeight(value: Int)
fun View.resize(width: Int, height: Int)
...
```

### CommonExt

```kotlin
fun findColor(@ColorRes resId: Int) 
fun findDrawable(@DrawableRes resId: Int)
fun findColorStateList(@ColorRes resId: Int)
...
```

### DisplayExt

```kotlin
val screenWidth: Int
val screenHeight: Int
val screenDensity: Float
...
```

### DateTimeExt

```kotlin
fun Long.year()
fun Long.month()
fun Long.day()
...
```

### StringExt

```kotlin
fun String.toast()
fun String.md5()
fun String.sha1()
...
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
...
```

### ManagerExt

```kotlin
val connectivityManager
val alarmManager
val telephonyManager
val activityManager
...
```

### SharedPreferencesExt

```kotlin
fun spSetInt(key: String, value: Int)
fun spGetInt(key: String, defaultValue: Int = 0)
...
```

### BitmapExt

```kotlin
fun Bitmap.toBase64(): String
fun Bitmap.resize(w: Number, h: Number): Bitmap
...
```

### FileExt

```kotlin
fun File.copy(dest: File)
fun File.copyDirectory(dest: File)
...
```

### ToastExt

```kotlin
fun toast(msg: Any, isShort: Boolean = true) 
```

### ActivityExt

```kotlin
fun Activity.goActivity<T>()
fun Activity.goActivity<T>(requestCode: Int)
...
```

### FragmentExt (support.v4)

```kotlin
fun Fragment.goActivity<T>()
fun Fragment.goActivity<T>(requestCode: Int)
...
```

### ActivityMgr

```kotlin
fun add(activity: Activity)
fun remove(activity: Activity)
fun removeAll()
...
```

### ApiExt

```kotlin
fun aboveApi(api: Int, included: Boolean = false, block: () -> Unit)
fun belowApi(api: Int, included: Boolean = false, block: () -> Unit)
```

[[点这查看所有支持的扩展API(readmore)]](./DETAIL.md)
