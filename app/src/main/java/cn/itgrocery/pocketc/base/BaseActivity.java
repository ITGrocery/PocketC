package cn.itgrocery.pocketc.base;

import android.widget.Toast;

import javax.inject.Inject;

import cn.itgrocery.pocketc.app.App;
import cn.itgrocery.pocketc.di.component.ActivityComponent;
import cn.itgrocery.pocketc.di.component.DaggerActivityComponent;
import cn.itgrocery.pocketc.di.module.ActivityModule;

/**
 * Created by xc on 2017/12/23.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView{

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent
                .builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();

    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onViewCreated() {
        initInject();
        if(mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    protected abstract void initInject();

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
