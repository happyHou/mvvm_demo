package test.mvvm.demo.view;

import android.view.View;

import java.util.ArrayList;
import java.util.List;


import test.mvvm.demo.BR;
import test.mvvm.demo.R;
import test.mvvm.demo.databinding.ActivityMainBinding;
import test.mvvm.demo.view.adapter.MainPagerAdapter;
import test.mvvm.demo.viewmodel.MainViewModel;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    protected int getVariableId() {
        return BR.vm;
    }

    @Override
    protected void setUpView() {
        List<HomeFragment> list=new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        MainPagerAdapter adapter=new MainPagerAdapter(getSupportFragmentManager(),list);
        binding.viewPager.setAdapter(adapter);
        binding.tab1.setOnClickListener((View view)->{
            binding.viewPager.setCurrentItem(0);
        });
        binding.tab2.setOnClickListener((View view)->{
            binding.viewPager.setCurrentItem(1);
        });
    }
}
