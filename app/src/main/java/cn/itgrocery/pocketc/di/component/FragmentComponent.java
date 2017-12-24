package cn.itgrocery.pocketc.di.component;

import android.app.Activity;

import cn.itgrocery.pocketc.di.module.FragmentModule;
import cn.itgrocery.pocketc.di.scope.FragmentScope;
import dagger.Component;

/**
 * Created by xc on 2017/12/24.
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
}
