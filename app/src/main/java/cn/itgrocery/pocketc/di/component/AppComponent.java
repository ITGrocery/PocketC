package cn.itgrocery.pocketc.di.component;

import javax.inject.Singleton;

import cn.itgrocery.pocketc.app.App;
import cn.itgrocery.pocketc.di.module.AppModule;
import dagger.Component;

/**
 * Created by xc on 2017/12/23.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    App getContext();
}
