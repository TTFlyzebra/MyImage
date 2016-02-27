package com.flyzebra.myimage.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyzebra.myimage.R;

public class viewpager_image extends Fragment {
    private static final String ARG_LIST = "filelist";
    private static final String ARG_CURRENT = "current";
    private ViewPager viewpager = null;
    private int fm_num;
    private MyPagerAdapter pageradapter = null;
    private List<String> file_list = null;
    private int current = 1;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 11:
                    viewpager.setCurrentItem(current, false);
                    break;
            }
        }
    };

    public viewpager_image() {
    }

    public static viewpager_image newInstace(ArrayList<String> filelist, int current) {
        viewpager_image fragment = new viewpager_image();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_LIST, filelist);
        args.putInt(ARG_CURRENT, current);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        ArrayList<String> list = args.getStringArrayList(ARG_LIST);
        if (!list.isEmpty()) {
            file_list = new ArrayList<String>();
            file_list.add(list.get(list.size() - 1));
            file_list.addAll(list);
            file_list.add(list.get(0));
        }
        current = args.getInt(ARG_CURRENT, 0);
        current++;
        fm_num = file_list.size();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpager, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        pageradapter = new MyPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(pageradapter);
        if (current >= 0) {
            viewpager.setCurrentItem(current);
        }

    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int item) {
            return Fragment_image.newInstance(file_list.get(item));
        }

//		@Override
//		public void destroyItem(ViewGroup container, int position, Object object) {
//			 ((ViewPager) container).removeView((View)object);  
//		}

        @Override
        public int getCount() {
            return fm_num;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position,
                                   Object object) {
            if (position == 0) {
                current = fm_num - 2;
                mHandler.sendEmptyMessage(11);
            } else if (position == fm_num - 1) {
                current = 1;
                mHandler.sendEmptyMessage(11);
            } else {
                current = position;
            }
            position = current;
            super.setPrimaryItem(container, position, object);
        }

    }

}
