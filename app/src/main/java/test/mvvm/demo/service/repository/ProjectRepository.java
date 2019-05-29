package test.mvvm.demo.service.repository;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.mvvm.demo.ConstantConfig;
import test.mvvm.demo.service.model.TodayBean;
import test.mvvm.demo.view.BaseActivity;

public class ProjectRepository {
    private static ProjectRepository repository;
    private static HomeService homeService;

    public static ProjectRepository getInstance(){
        if (repository==null || homeService==null) {
            repository =new ProjectRepository();
        }
        return repository;

    }


    private ProjectRepository() {
        getApiService();
    }

    private static HomeService getApiService(){
        if (homeService==null) {
            homeService = new Retrofit.Builder()
                    .baseUrl(ConstantConfig.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(HomeService.class);
        }
        return homeService;
    }

    public Observable<TodayBean> getTodayData(BaseActivity context){
        return getApiService().getToday();
    }

}
