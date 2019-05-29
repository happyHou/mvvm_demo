package test.mvvm.demo.view;

import test.mvvm.demo.BR;
import test.mvvm.demo.R;
import test.mvvm.demo.databinding.FragmentHomeBinding;
import test.mvvm.demo.viewmodel.HomeViewModel;

public class HomeFragment extends BaseFragment<FragmentHomeBinding,HomeViewModel>{
    @Override
    protected void setUpViews() {

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
