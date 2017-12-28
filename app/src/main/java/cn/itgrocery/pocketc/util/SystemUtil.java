package cn.itgrocery.pocketc.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.itgrocery.pocketc.app.App;

/**
 * Created by chenxl on 2017/12/28.
 */

public class SystemUtil {

    //检查网络是否可用
    public static boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
