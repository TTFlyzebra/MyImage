package com.flyzebra.myimage.data;

import android.os.Environment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016/2/27.
 */
public class ImageListUtils {
    public static ArrayList<String> getImagesFromSDPath(String path){
        ArrayList<String > list = new ArrayList<>();
        //判断SDCARD是否存在
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File file = Environment.getExternalStorageDirectory();
            String strPath = file.getAbsolutePath()+File.separator+path;
            File f1 = new File(strPath);
            if(f1.exists()){
                file = f1;
            }
            ImageFilter imageFilter = new ImageFilter();
            File listFile[] = file.listFiles(imageFilter);
            for(File ifile:listFile){
                String str ="file://"+ifile.getAbsolutePath() ;
                list.add(str);
            }
            Collections.sort(list);
        }
        return list;
    }

    public static class ImageFilter implements FilenameFilter {
        public boolean isGif(String file) {
            if (file.toLowerCase(Locale.getDefault()).endsWith(".gif")) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isBmp(String file) {
            if (file.toLowerCase(Locale.getDefault()).endsWith(".bmp")) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isJpg(String file) {
            if (file.toLowerCase(Locale.getDefault()).endsWith(".jpg")) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isPng(String file) {
            if (file.toLowerCase(Locale.getDefault()).endsWith(".png")) {
                return true;
            } else {
                return false;
            }
        }
        public boolean accept(File dir, String fname) {
            return (isGif(fname)||isBmp(fname)|| isJpg(fname) || isPng(fname));
        }
    }
}
