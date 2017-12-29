package cn.itgrocery.pocketc.presenter.main;

import com.orhanobut.logger.Logger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import cn.itgrocery.pocketc.base.RxPresenter;
import cn.itgrocery.pocketc.base.contract.main.MainContract;
import cn.itgrocery.pocketc.model.http.RetrofitHelper;
import cn.itgrocery.pocketc.model.pojo.MyJoke;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by xc on 2017/12/23.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    RetrofitHelper retrofitHelper;

    /**
     * 对于可以自行管理的类无需创建Module来提供实例化的对象
     */
    @Inject
    public MainPresenter(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    @Override
    public void testDagger() {
        mView.showMessage("From MainPresenter!");
    }

    @Override
    public void testRetrofit2() {
        retrofitHelper.fetchJokes().subscribe(new ResourceSubscriber<List<MyJoke>>() {
            @Override
            public void onNext(List<MyJoke> myJokes) {
                Logger.d(myJokes.toString());
            }

            @Override
            public void onError(Throwable t) {
                Logger.e("onError");
            }

            @Override
            public void onComplete() {
                Logger.d("onComplete");
            }
        });
    }
}
