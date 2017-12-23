package cn.itgrocery.pocketc.base;

/**
 * Created by xc on 2017/12/23.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
