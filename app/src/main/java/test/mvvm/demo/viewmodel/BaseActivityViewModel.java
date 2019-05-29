package test.mvvm.demo.viewmodel;

import androidx.lifecycle.ViewModel;
import test.mvvm.demo.view.BaseActivity;

public class BaseActivityViewModel extends ViewModel {
    protected BaseActivity context;

    public BaseActivityViewModel(BaseActivity context) {
        this.context=context;
    }

    public void onResume(){

    }
}
