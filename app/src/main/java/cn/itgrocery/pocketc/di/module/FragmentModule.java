package cn.itgrocery.pocketc.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import cn.itgrocery.pocketc.di.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by xc on 2017/12/24.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity(){
        return fragment.getActivity();
    }
}
