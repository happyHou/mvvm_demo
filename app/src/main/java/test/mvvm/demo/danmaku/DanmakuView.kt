package test.mvvm.demo.danmaku

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Paint
import android.os.Build
import android.text.Html
import android.text.SpannableString
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Scroller
import android.widget.TextView
import test.mvvm.demo.App
import test.mvvm.demo.R
import java.util.*

/**
 * 弹幕view
 * Author: pangzhen
 * Date: 2019/4/28 11:23
 */
class DanmakuView : RelativeLayout {


    /**
     * 弹幕进场时的监听
     */
    interface OnEnterListener {
        fun onEnter(view: DanmakuView)
    }

    /**
     * 弹幕离场后的监听
     */
    interface OnExitListener {
        fun onExit(view: DanmakuView)
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private lateinit var danmakuRoot: RelativeLayout
    private lateinit var danmakuText: TextView
    private fun init(context: Context, attrs: AttributeSet?) {
        val rootLayout = LayoutInflater.from(context).inflate(R.layout.layout_widget_danmaku_view, this)

        danmakuRoot = rootLayout.findViewById(R.id.sy_danmaku_root)
        danmakuText = rootLayout.findViewById<TextView>(R.id.sy_danmaku_text)
    }


    /**
     * 显示弹幕
     */
    fun show(parent: ViewGroup, duration: Long) {
        showScrollDanmaku(parent, duration)
    }

    private fun showScrollDanmaku(parent: ViewGroup, duration: Long) {
        layoutParams =
            RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) as ViewGroup.LayoutParams?
        this.layoutParams = layoutParams
        parent.addView(this)
        startAnim(parent, duration)

    }

    private fun startAnim(parent: ViewGroup, duration: Long) {
        val screenWidth = App.instance.screenWidth
        val anim =
            ObjectAnimator.ofFloat(this@DanmakuView, "translationX", screenWidth.toFloat(), -screenWidth.toFloat())
        anim.interpolator = LinearInterpolator()
        anim.duration = duration

        anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                animation?.cancel()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
        anim.start()
    }


}
