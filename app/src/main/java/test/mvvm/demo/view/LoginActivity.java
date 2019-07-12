package test.mvvm.demo.view;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.mvvm.demo.R;


@Route(path = "/test/loginAct")
public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login).setOnClickListener(v ->
                LoginInterceptor.loginFlag=true
                );

        findViewById(R.id.loginOut).setOnClickListener(v ->
                LoginInterceptor.loginFlag=false
        );
    }


}
