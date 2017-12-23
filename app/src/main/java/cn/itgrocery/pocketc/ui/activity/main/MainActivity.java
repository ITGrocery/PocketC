package cn.itgrocery.pocketc.ui.activity.main;

import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.BaseActivity;
import cn.itgrocery.pocketc.base.contract.main.MainContract;
import cn.itgrocery.pocketc.presenter.main.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    @Override
    protected void initEventAndData() {
        mPresenter.testDagger();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showMessage(String info) {
        showErrorMsg(info);
    }
}
