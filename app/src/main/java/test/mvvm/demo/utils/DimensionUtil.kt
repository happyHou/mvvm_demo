package test.mvvm.demo.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Surface
import android.view.WindowManager

/**
 * 尺寸转换工具类
 */
object DimensionUtil {

    /** 将dp转换成px  */
    fun dip2px(dipValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

    fun dip2pxfloat(dipValue: Float): Float {
        val scale = Resources.getSystem().displayMetrics.density
        return (dipValue * scale + 0.5f)
    }

    fun dip2px(context: Context, dipValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

    /** px转成为dp  */
    fun px2dip(pxValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /** sp转成为px  */
    fun sp2px(spValue: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            spValue, Resources.getSystem().displayMetrics
        ).toInt()
    }

    /** px转sp  */
    fun px2sp(pxValue: Float): Float {
        return pxValue / Resources.getSystem().displayMetrics.scaledDensity
    }

    /**
     * 返回手机分辨率（宽*高）。注意：返回值手机屏幕是否旋转无关。
     * @return null - 失败
     */
    fun getResolution(context: Context): String? {
        val info = getDispInfo(context)
        if (info[0] == -1 || info[1] == -1) return null
        return if (info[2] == Surface.ROTATION_0 || info[2] == Surface.ROTATION_180)
            info[0].toString() + "x" + info[1]
        else
            info[1].toString() + "x" + info[0]
    }

    /**
     * 返回手机当前屏幕宽带
     * @return < 0 - 失败
     */
    fun getWidth(context: Context): Int {
        return getDispInfo(context)[0]
    }

    /**
     * 返回手机当前屏幕高度
     * @return < 0 - 失败
     */
    fun getHeight(context: Context): Int {
        return getDispInfo(context)[1]
    }

    /**
     * 获得状态栏的高度
     * @param context
     * @return
     */
    fun getStatusHeight(context: Context): Int {
        var statusHeight = -1
        try {
            val clazz = Class.forName("com.android.internal.R\$dimen")
            val `object` = clazz.newInstance()
            val height = Integer.parseInt(clazz.getField("status_bar_height").get(`object`).toString())
            statusHeight = context.resources.getDimensionPixelSize(height)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return statusHeight
    }

    // 内部函数
    private fun getDispInfo(context: Context?): IntArray {
        if (context == null) return intArrayOf(-1, -1)
        val dm =
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay ?: return intArrayOf(
                -1,
                -1
            )
        return if (Build.VERSION.SDK_INT < 14) {
            intArrayOf(dm.width, dm.height, dm.rotation)
        } else {
            try {
                val size = Point()
                val method = dm.javaClass.getMethod("getRealSize", Point::class.java)
                method.invoke(dm, size)
                intArrayOf(size.x, size.y, dm.rotation)
            } catch (e: Exception) {
                intArrayOf(-1, -1)
            }

        }
    }

    /**
     * 精确获取屏幕尺寸（例如：3.5、4.0、5.0寸屏幕）
     * @param ctx
     * @return
     */
    fun getScreenPhysicalSize(ctx: Context): Double {
        val dm = DisplayMetrics()
        (ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(dm)
        val diagonalPixels =
            Math.sqrt(Math.pow(dm.widthPixels.toDouble(), 2.0) + Math.pow(dm.heightPixels.toDouble(), 2.0))
        return diagonalPixels / (160 * dm.density)
    }

    /**
     * 判断是否是平板（官方用法）
     * @param context
     * @return
     */
    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }

    fun countEmojiLength(string: String): Int {
        var regexAstralSymbols = "/[\uD800-\uDBFF][\uDC00-\uDFFF]/g".toRegex()
        return string.replace(regexAstralSymbols, "_").length
    }
}