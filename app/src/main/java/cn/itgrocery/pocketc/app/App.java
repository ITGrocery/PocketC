package cn.itgrocery.pocketc.app;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import cn.itgrocery.pocketc.R;

/**
 * Created by xc on 2017/12/23.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initSettings();
        Logger.d("init settings finish");
    }

    private void initSettings() {
        initLogger();
    }

    private void initLogger() {
        PrettyFormatStrategy formatStrategy = PrettyFormatStrategy
                .newBuilder()
                .tag(getResources().getString(R.string.app_name))
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
