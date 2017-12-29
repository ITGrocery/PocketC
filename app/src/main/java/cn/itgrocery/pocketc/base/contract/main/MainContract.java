package cn.itgrocery.pocketc.base.contract.main;

import cn.itgrocery.pocketc.base.BasePresenter;
import cn.itgrocery.pocketc.base.BaseView;

/**
 * Created by xc on 2017/12/23.
 */

public interface MainContract {

    interface View extends BaseView{
        void showMessage(String info);
    }

    interface Presenter extends BasePresenter<View>{
        void testDagger();

        void testRetrofit2();
    }
}
