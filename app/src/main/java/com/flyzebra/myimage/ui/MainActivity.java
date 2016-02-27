package com.flyzebra.myimage.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;

import com.flyzebra.myimage.R;
import com.flyzebra.myimage.data.ImageListUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView ac_gv01;
    private ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac_gv01 = (GridView) findViewById(R.id.ac_gv01);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int imageSize;
        if(dm.widthPixels<dm.heightPixels){
            imageSize = dm.widthPixels / 3;
            ac_gv01.setNumColumns(3);
        }else{
            imageSize = dm.heightPixels / 3;
            float colnum = (float)dm.widthPixels/(float)dm.heightPixels*3.0f;
            ac_gv01.setNumColumns((int) colnum);
        }

        List<String> list = ImageListUtils.getImagesFromSDPath("DCIM");
        imageAdapter = new ImageAdapter(this,list,imageSize);
        ac_gv01.setAdapter(imageAdapter);
    }
}
