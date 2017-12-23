package cn.itgrocery.pocketc.di.module;

import android.app.Activity;

import cn.itgrocery.pocketc.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by xc on 2017/12/23.
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return activity;
    }
}
