package cn.itgrocery.pocketc.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itgrocery.pocketc.app.App;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by xc on 2017/12/23.
 */

public abstract class SimpleActivity extends SupportActivity {

    protected Activity mContext;
    private Unbinder mUnbinder;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        App.getInstance().addActivity(this);
        onViewCreated();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        App.getInstance().removeActivity(this);
    }

    protected abstract void initEventAndData();

    protected abstract void onViewCreated();

    protected abstract int getLayoutId();
}
