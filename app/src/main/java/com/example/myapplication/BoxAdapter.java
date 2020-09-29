package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class BoxAdapter extends BaseAdapter {
    private Context mContext;
    public static final String TAG = "BoxAdapter";

    public BoxAdapter(Context context, int n) {
        mContext = context;
        multiArray(n);

    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }
        imageView.setImageResource(mThumbIds[i]);
        return imageView;
    }

    public int[] mThumbIds = {
            R.drawable.box,
    };

    public void multiArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = R.drawable.box;
        }
        mThumbIds = a;
    }
}
