package com.flyzebra.myimage.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.flyzebra.myimage.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * GridViewAdapter
 * Created by Administrator on 2016/2/27.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    private DisplayImageOptions options;
    private int imageSize;

    public ImageAdapter(Context context, List<String> list, int imageSize) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
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
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.gv01, null);
            holder.iv01 = (ImageView) convertView.findViewById(R.id.gv01_iv01);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //         动态设置ImageView高度
//        ViewGroup.LayoutParams para = holder.iv01.getLayoutParams();
//        para.width = imageSize - 10;
//        para.height = imageSize - 10;
//        holder.iv01.setLayoutParams(para);
//        holder.iv01.setMaxHeight(imageSize);
//        holder.iv01.setMaxHeight(imageSize);
//        holder.iv01.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageLoader.getInstance().displayImage(list.get(position), holder.iv01, options);
        return convertView;
    }

    static class ViewHolder {
        ImageView iv01;
    }
}
