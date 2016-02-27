package com.flyzebra.myimage.ui;

import com.flyzebra.myimage.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_image extends Fragment {
	public String TAG = "com.flyzebra";
	private static final String ARG_PATH = "filepath";
	private String filepath;
	private ImageView fm_image_iv01;
	private ImageView fm_image_iv02;
	private DisplayImageOptions options;

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
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_image, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		fm_image_iv01 = (ImageView) view.findViewById(R.id.fm_image_iv01);
		fm_image_iv02 = (ImageView) view.findViewById(R.id.fm_image_iv02);
		fm_image_iv01.setSoundEffectsEnabled(false);
		fm_image_iv02.setSoundEffectsEnabled(false);
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.build();
	}

	@Override
	public void onStart() {
		super.onStart();
		ImageLoader.getInstance().displayImage(filepath, fm_image_iv01, options);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	}

}
