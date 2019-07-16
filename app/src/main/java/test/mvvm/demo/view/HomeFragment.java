package test.mvvm.demo.view;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import javax.security.auth.login.LoginException;

import androidx.appcompat.widget.DialogTitle;
import test.mvvm.demo.BR;
import test.mvvm.demo.R;
import test.mvvm.demo.danmaku.DanmakuView;
import test.mvvm.demo.databinding.FragmentHomeBinding;
import test.mvvm.demo.viewmodel.HomeViewModel;

public class HomeFragment extends BaseFragment<FragmentHomeBinding,HomeViewModel>{
    private static final String TAG = "HomeFragment";
    private String hi="hihi";

    public static HomeFragment newInstance(String hi){
        HomeFragment fragment=new HomeFragment();
        fragment.hi=hi;
        return fragment;
    }

    @Override
    protected void setUpViews() {
        View inflate = getLayoutInflater().inflate(R.layout.inner_textview, binding.danmuContainer, false);
        binding.danmuContainer.addView(inflate);
        binding.danmuContainer.setOnClickListener(v -> {
            Log.e(TAG, "setUpViews: ");
            ARouter.getInstance().build("/test/secondAct")
                    .withString("hi","hihi")
                    .navigation(getActivity());
        });

        DanmakuView danmakuView=new DanmakuView(getActivity());
        danmakuView.show(binding.danmuContainer,9000L);
        binding.hi.setText(hi);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected int getVeriableId() {
        return BR.vm;
    }

    @Override
    protected HomeViewModel createViewModel() {
        return new HomeViewModel(this);
    }
}
