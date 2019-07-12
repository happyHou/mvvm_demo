package test.mvvm.demo.view;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

@Interceptor(priority = 1, name = "login interceptor")
public class LoginInterceptor implements IInterceptor {
    private static final String TAG = "LoginInterceptor";
    private Context mContext;
    public static boolean loginFlag=false;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (loginFlag) {
            callback.onContinue(postcard);
        }else {
            Postcard postcard1 = ARouter.getInstance()
                    .build("/test/loginAct")
                    .withString("hi", "hi");

            Log.e(TAG, "process: >>>>>" );

            callback.onContinue(postcard1);
//            callback.onInterrupt(new Exception("没有登录"));
        }

    }

    @Override
    public void init(Context context) {
        this.mContext=context;

    }
}
