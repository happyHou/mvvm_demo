package test.mvvm.demo.video;

import android.content.Context;
import android.util.AttributeSet;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

public class MyControlVideo extends StandardGSYVideoPlayer implements GSYVideoPlayer {
    public MyControlVideo(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public MyControlVideo(Context context) {
        super(context);
    }

    public MyControlVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }







}
