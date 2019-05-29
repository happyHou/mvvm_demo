package test.mvvm.demo.service.repository;

import io.reactivex.Observable;
import retrofit2.http.GET;
import test.mvvm.demo.service.model.TodayBean;

public interface HomeService {

    @GET("today")
    Observable<TodayBean> getToday();

}
