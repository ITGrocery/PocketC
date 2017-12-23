package cn.itgrocery.pocketc.di.module;

import javax.inject.Singleton;

import cn.itgrocery.pocketc.app.App;
import dagger.Module;
import dagger.Provides;

/**
 * Created by xc on 2017/12/23.
 */
@Module
public class AppModule {

    private final App application;

    public AppModule(App application){
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext(){
        return application;
    }
}
