package cn.itgrocery.pocketc.model.http;

import java.util.List;

import javax.inject.Inject;

import cn.itgrocery.pocketc.model.http.api.TestApi;
import cn.itgrocery.pocketc.model.pojo.MyJoke;
import io.reactivex.Observable;

/**
 * Created by chenxl on 2017/12/28.
 */

public class RetrofitHelper {

    private TestApi testApi;

    @Inject
    public RetrofitHelper(TestApi testApi){
        this.testApi = testApi;
    }

    public Observable<List<MyJoke>> fetchJokes(){
        return testApi.getData();
    }
}
