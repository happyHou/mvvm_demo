package test.mvvm.demo.view;

import android.view.View;

import test.mvvm.demo.BR;
import test.mvvm.demo.R;
import test.mvvm.demo.databinding.FragmentHomeBinding;
import test.mvvm.demo.viewmodel.HomeViewModel;

public class HomeFragment extends BaseFragment<FragmentHomeBinding,HomeViewModel>{
    @Override
    protected void setUpViews() {
        View inflate = getLayoutInflater().inflate(R.layout.inner_textview, binding.danmuContainer, false);
        binding.danmuContainer.addView(inflate);

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
