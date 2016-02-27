package com.flyzebra.myimage.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.flyzebra.myimage.R;

public class ImageActivity extends FragmentActivity {
	public static final String TAG = "com.flyzebra";
	private ArrayList<String> file_list = null;
	private int id=-1;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_image);
		Intent intent = getIntent();
		if(id==-1){
			id = intent.getIntExtra("ID", 0);
		}
		if(file_list==null){
			file_list = intent.getStringArrayListExtra("file_list");
		}
		viewpager_image fragment = viewpager_image.newInstace(file_list, id);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.im_main_fl01, fragment);
		ft.commit();
	}
	
}
