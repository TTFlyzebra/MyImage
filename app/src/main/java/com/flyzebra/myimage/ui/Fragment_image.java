package com.flyzebra.myimage.ui;

import com.flyzebra.myimage.R;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Fragment_image extends Fragment {
	public String TAG = "com.flyzebra";
	private static final String ARG_PATH = "filepath";
	private static final int SCREEN_W = 11;
	private static final int SCREEN_H = 12;	
	private String filepath;
	private ImageView fm_image_iv01;
	private ImageView fm_image_iv02;


	public Fragment_image() {
	}

	public static Fragment_image newInstance(String filepath) {
		Fragment_image fragment = new Fragment_image();
		Bundle args = new Bundle();
		args.putString(ARG_PATH, filepath);
		fragment.setArguments(args);
		return fragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		filepath = args.getString(ARG_PATH);
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);			
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_image, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Log.i(TAG,"Fragment_image->onViewCreated");
		fm_image_iv01 = (ImageView) view.findViewById(R.id.fm_image_iv01);
		fm_image_iv02 = (ImageView) view.findViewById(R.id.fm_image_iv02);
		fm_image_iv01.setSoundEffectsEnabled(false);
		fm_image_iv02.setSoundEffectsEnabled(false);
	}
	
	@Override
	public void onResume() {
		super.onStart();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	}

}
