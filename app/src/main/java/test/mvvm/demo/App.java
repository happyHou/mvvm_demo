package test.mvvm.demo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ScreenUtils;

import androidx.multidex.MultiDexApplication;


public class App extends MultiDexApplication {

    public static String hi;
    public static App instance;
    public int screenWidth ;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        screenWidth = ScreenUtils.getScreenWidth();

        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As e

    }
}
