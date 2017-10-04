package pers.victor.ext

import android.app.Activity
import kotlin.reflect.KClass

/**
 * Created by victor on 16-6-14. (ง •̀_•́)ง
 */

object ActivityMgr {
    private val container = arrayListOf<Activity>()

    @Synchronized
    fun add(activity: Activity) = container.add(activity)

    @Synchronized
    fun current(): Activity? = if (container.isEmpty()) null else container[container.lastIndex]

    @Synchronized
    fun <T : Activity> findFirst(clazz: KClass<T>): T? = container.firstOrNull { it::class == clazz } as? T

    @Synchronized
    fun <T : Activity> findLast(clazz: KClass<T>): T? = container.lastOrNull { it::class == clazz } as? T

    @Synchronized
    fun <T : Activity> find(clazz: KClass<T>): List<T> = container.filter { it::class == clazz }.map { it as T }

    @Synchronized
    fun remove(activity: Activity) = container.remove(activity)

    @Synchronized
    fun removeAll() = container.clear()

    @Synchronized
    fun finishFirst(clazz: KClass<*>) = container.firstOrNull { it::class == clazz }?.let { finish(it) }

    @Synchronized
    fun finishLast(clazz: KClass<*>) = container.lastOrNull { it::class == clazz }?.let { finish(it) }

    @Synchronized
    fun finish(clazz: KClass<*>) = container
            .filter { it::class == clazz }
            .forEach { finish(it) }

    @Synchronized
    fun finishExcept(vararg clazz: KClass<*>) {
        if (clazz.isEmpty()) {
            finishAll()
            return
        }
        for (i in container.indices.reversed()) {
            val cur = container[i]
            val b = clazz.any { it == cur::class }
            if (!b) finish(cur)
        }
    }

    @Synchronized
    fun finishAll() {
        container.forEach { it.finish() }
        container.clear()
    }

    @Synchronized
    private fun finish(activity: Activity) {
        container.remove(activity)
        activity.finish()
    }

    @Synchronized
    fun activities(): List<Activity> = container
}