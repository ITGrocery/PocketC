package cn.itgrocery.pocketc.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.HashSet;
import java.util.Set;

import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.di.component.AppComponent;
import cn.itgrocery.pocketc.di.component.DaggerAppComponent;
import cn.itgrocery.pocketc.di.module.AppModule;

/**
 * Created by xc on 2017/12/23.
 */

public class App extends Application {

    private static App instance = null;
    private static int SCREEN_WIDTH = -1;
    private static int SCREEN_HEIGHT = -1;
    private static AppComponent appComponent;

    private Set<Activity> allActivities;

    public static App getInstance(){
        if(instance == null){
            Logger.e("App为空，请检查代码是否有误！");
        }
        return instance;
    }

    public static int getScreenWidth(){
        if(SCREEN_WIDTH == -1){
            Logger.e("屏幕宽度未初始化，请检查代码是否有误！");
        }
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight(){
        if(SCREEN_HEIGHT == -1){
            Logger.e("屏幕高度未初始化，请检查代码是否有误！");
        }
        return SCREEN_HEIGHT;
    }

    public void addActivity(Activity activity){
        if(allActivities == null){
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity){
        if(allActivities != null){
            allActivities.remove(activity);
        }
    }

    public void exitApp(){
        if(allActivities != null){
            for (Activity activity : allActivities) {
                activity.finish();
            }
        }

        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public void setScreenSize(){
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        SCREEN_WIDTH = display.getWidth();
        SCREEN_HEIGHT = display.getHeight();

        Logger.d("当前屏幕的宽为：%s",SCREEN_WIDTH);
        Logger.d("当前屏幕的高为：%s",SCREEN_HEIGHT);
    }

    public static AppComponent getAppComponent(){
        if(appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .build();
        }
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化基础配置
        initSettings();
        Logger.i("基础配置初始化完成！");
        //获取屏幕的宽高
        setScreenSize();
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
