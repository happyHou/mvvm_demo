package test.mvvm.demo.viewmodel;

import androidx.lifecycle.ViewModel;
import test.mvvm.demo.view.BaseFragment;

public class BaseFragmentViewModel extends ViewModel {
    protected BaseFragment fragment;

    public BaseFragmentViewModel(BaseFragment fragment) {
        this.fragment = fragment;
    }
}
