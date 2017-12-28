package cn.itgrocery.pocketc.model.http.api;

import java.util.List;

import cn.itgrocery.pocketc.model.pojo.MyJoke;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by chenxl on 2017/12/28.
 */

public interface TestApi {

    String HOST = "http://api.laifudao.com/open/";

    @GET("xiaohua.json")
    Observable<List<MyJoke>> getData();
}
