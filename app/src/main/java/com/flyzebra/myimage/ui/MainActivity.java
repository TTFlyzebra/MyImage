package com.flyzebra.myimage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.flyzebra.myimage.R;
import com.flyzebra.myimage.data.ImageListUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView ac_gv01;
    private ImageAdapter imageAdapter;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac_gv01 = (GridView) findViewById(R.id.ac_gv01);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        if(dm.widthPixels<dm.heightPixels){
            ac_gv01.setNumColumns(3);
        }else{
            float colnum = (float)dm.widthPixels/(float)dm.heightPixels*3.0f;
            ac_gv01.setNumColumns((int) colnum);
        }

        list = ImageListUtils.getImagesFromSDPath("DCIM");
        imageAdapter = new ImageAdapter(this,list);
        ac_gv01.setAdapter(imageAdapter);
        ac_gv01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ID", (int) id);
                intent.putStringArrayListExtra("file_list", list);
                startActivity(intent);
            }
        });
    }
}
