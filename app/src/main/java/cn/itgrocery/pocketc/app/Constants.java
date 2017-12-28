package cn.itgrocery.pocketc.app;

import java.io.File;

/**
 * Created by xc on 2017/12/23.
 */

public class Constants {

    //path
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CAHE = PATH_DATA + File.separator + "NetCache";
}
