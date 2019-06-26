package test.mvvm.demo;

import android.app.Application;

import test.mvvm.demo.utils.DimensionUtil;


public class App extends Application {

    public static App instance;
    public int screenWidth ;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        screenWidth =  DimensionUtil.INSTANCE.getWidth(this);
    }
}
