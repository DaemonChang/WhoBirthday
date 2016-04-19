package com.cskaoyan.birthday.whobirthday.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by whb on 2016/4/19.
 */
public class MyApplication extends Application {

    public static SharedPreferences configsp;

    public static  SharedPreferences.Editor editor;

    /**
     * password 是本软件的应用锁
     *
     * userpassword 是当前账户密码
     */

    @Override
    public void onCreate() {
        super.onCreate();

        configsp=getSharedPreferences("config", MODE_PRIVATE);
        editor =configsp.edit();

        Log.i("MyApplication","MyApplication onCreate");

    }
}
