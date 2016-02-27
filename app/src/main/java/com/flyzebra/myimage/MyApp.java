package com.flyzebra.myimage;

import android.app.Application;

import com.flyzebra.myimage.data.ImageLoaderConfig;

/**
 * 全局App
 * Created by Flyzebra on 2016/2/27.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfig.initImageLoader(getApplicationContext());
    }


}
