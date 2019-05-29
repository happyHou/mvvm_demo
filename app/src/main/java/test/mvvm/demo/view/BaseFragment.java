package test.mvvm.demo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle3.components.support.RxFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import test.mvvm.demo.viewmodel.BaseActivityViewModel;
import test.mvvm.demo.viewmodel.BaseFragmentViewModel;

public abstract class BaseFragment<BINDING extends ViewDataBinding,VM extends BaseFragmentViewModel> extends RxFragment {

    protected BINDING binding;
    protected VM viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        binding= DataBindingUtil.bind(view);
        binding.setVariable(getVeriableId(),createViewModel());
        binding.executePendingBindings();
        setUpViews();
        return binding.getRoot();
    }

    protected abstract void setUpViews();

    protected abstract int getLayoutId();

    protected abstract int getVeriableId();

    protected abstract VM createViewModel();

}
