package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.view.View;

import com.gamedashi.dtcq.floatview.GlobalParams_float;
import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public abstract class BaseFloatView {

	public static MyWindowManager mMyWindowManager;
	public ImageLoader imageLoader = ImageLoader.getInstance();
	public DisplayImageOptions options;

	public Context mContext;

	public BaseFloatView(Context context) {

		this.mContext = context;

		imageLoader.init(ImageLoaderConfiguration
				.createDefault(MyFloatServes.mContext));
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(
						R.drawable.tz_gamedashi_dtcq_floatview_ic_error)
				.showImageForEmptyUri(
						R.drawable.tz_gamedashi_dtcq_floatview_ic_error)
				.showImageOnFail(
						R.drawable.tz_gamedashi_dtcq_floatview_ic_error)
				.cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
				.build();

		mMyWindowManager = MyWindowManager.getInstance(mContext);

	}

	/**
	 * 返回浮窗
	 * 
	 * @return
	 */
	public abstract View getFloatView();

	/**
	 * 初始化浮窗
	 */
	public abstract void initView();

	/**
	 * 离开屏幕
	 */
	public void remove() {

		if (this.getFloatView().getParent() != null) {

			MyWindowManager.getInstance(MyFloatServes.mContext).removeView(
					this.getFloatView());

		}

	}

}
