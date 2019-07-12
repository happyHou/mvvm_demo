package test.mvvm.demo.danmaku;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import test.mvvm.demo.App;
import test.mvvm.demo.R;

public class DanmakuView extends RelativeLayout {
    private static final String TAG = "DanmakuView";
    public DanmakuView(Context context) {
        super(context);
        init(context);
    }

    public DanmakuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DanmakuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private RelativeLayout danmakuRoot;
    private TextView danmakuText;
    private void init(Context context){
        View rootLayout = LayoutInflater.from(context).inflate(R.layout.layout_widget_danmaku_view, this,true);

        danmakuRoot = rootLayout.findViewById(R.id.sy_danmaku_root);
        danmakuText = rootLayout.findViewById(R.id.sy_danmaku_text);
    }

    /**
     * 显示弹幕
     */
    public void show(ViewGroup parent, Long duration) {
        showScrollDanmaku(parent, duration);
    }

    private void showScrollDanmaku(ViewGroup parent, Long duration) {
//        LayoutParams layoutParams =
//                new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                this.setLayoutParams( layoutParams);

        int width = danmakuText.getWidth();
        Log.e(TAG, "showScrollDanmaku: "+width );
        parent.addView(this);
        startAnim(parent, duration);

    }

    private void startAnim(ViewGroup parent, Long duration) {
        float screenWidth = App.instance.screenWidth;
        ObjectAnimator anim =
                ObjectAnimator.ofFloat(this, "translationX", screenWidth, -screenWidth);
        anim.setDuration(duration);

        anim.addListener(new Animator.AnimatorListener() {


            @Override
            public void onAnimationStart(Animator animation, boolean isReverse) {

            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                animation.cancel();
            }

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

}
