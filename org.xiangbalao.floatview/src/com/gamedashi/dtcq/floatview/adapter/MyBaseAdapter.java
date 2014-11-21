package com.gamedashi.dtcq.floatview.adapter;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class MyBaseAdapter extends BaseAdapter {
	public MyWindowManager mMyWindowManager;
	
	public ImageLoader imageLoader = ImageLoader.getInstance();
	public DisplayImageOptions options;

	public MyBaseAdapter() {

		super();
		imageLoader.init(ImageLoaderConfiguration
				.createDefault(MyFloatServes.mContext));
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.tz_gamedashi_dtcq_floatview_ic_error)
				.showImageForEmptyUri(R.drawable.tz_gamedashi_dtcq_floatview_ic_error)
				.showImageOnFail(R.drawable.tz_gamedashi_dtcq_floatview_ic_error).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)
				.build();
		mMyWindowManager =MyWindowManager.getInstance(MyFloatServes.mContext);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return null;
	}

}
