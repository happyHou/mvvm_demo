package test.mvvm.demo.viewmodel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import test.mvvm.demo.service.model.TodayBean;
import test.mvvm.demo.service.repository.ProjectRepository;
import test.mvvm.demo.view.BaseActivity;

public class MainViewModel extends BaseActivityViewModel {
    private List<TodayBean.ResultsBean.CommonBean> list;


    public MainViewModel(BaseActivity context) {
        super(context);
    }

    private void requestData(){
        ProjectRepository.getInstance().getTodayData(context)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TodayBean>() {
                    @Override
                    public void accept(TodayBean todayBean) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

}
