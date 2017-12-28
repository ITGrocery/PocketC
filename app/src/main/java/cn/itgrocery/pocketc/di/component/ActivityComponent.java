package cn.itgrocery.pocketc.di.component;

import android.app.Activity;

import cn.itgrocery.pocketc.di.module.ActivityModule;
import cn.itgrocery.pocketc.di.scope.ActivityScope;
import cn.itgrocery.pocketc.model.http.RetrofitHelper;
import cn.itgrocery.pocketc.ui.main.activity.MainActivity;
import dagger.Component;

/**
 * Created by xc on 2017/12/23.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class} , modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);
}
