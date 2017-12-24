package cn.itgrocery.pocketc.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import cn.itgrocery.pocketc.app.App;
import cn.itgrocery.pocketc.di.component.DaggerFragmentComponent;
import cn.itgrocery.pocketc.di.component.FragmentComponent;
import cn.itgrocery.pocketc.di.module.FragmentModule;
import cn.itgrocery.pocketc.util.SnackbarUtil;

/**
 * Created by xc on 2017/12/24.
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView{

    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if(mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    protected abstract void initInject();
}
