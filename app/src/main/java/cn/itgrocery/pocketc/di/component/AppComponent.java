package cn.itgrocery.pocketc.di.component;

import javax.inject.Singleton;

import cn.itgrocery.pocketc.app.App;
import cn.itgrocery.pocketc.di.module.AppModule;
import cn.itgrocery.pocketc.di.module.HttpModule;
import cn.itgrocery.pocketc.model.http.RetrofitHelper;
import dagger.Component;

/**
 * Created by xc on 2017/12/23.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    RetrofitHelper getRetrofitHelper();
}
