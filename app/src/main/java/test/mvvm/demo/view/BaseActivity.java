package test.mvvm.demo.view;

import android.os.Bundle;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import test.mvvm.demo.viewmodel.BaseActivityViewModel;

public abstract class BaseActivity<BINDING extends ViewDataBinding,VM extends BaseActivityViewModel> extends RxAppCompatActivity {

    protected BINDING binding;
    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,getLayoutId());
        binding.setVariable(getVariableId(),viewModel);
        binding.executePendingBindings();
        setUpView();

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel!=null) {
            viewModel.onResume();
        }
    }

    protected abstract int getLayoutId();

    protected abstract int getVariableId();

    protected abstract void setUpView();
}
