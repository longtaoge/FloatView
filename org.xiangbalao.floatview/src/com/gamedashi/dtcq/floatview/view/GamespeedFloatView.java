package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.gamedashi.dtcq.floatview.utils.ToastUtils;

/**
 * 底部加速控制台
 * @author longtaoger
 *
 */
public class GamespeedFloatView extends BaseFloatView implements
		OnClickListener {

	private static ImageView subSpeed, andSpeed, reSet;
	private LinearLayout bgLinearLayout;
	private static Button set;
	private static Float speed = 1.0f;
	private TextView speed_text;


	private static GamespeedFloatView mGamespeedFloatViewIntance;
	public static View mView;

	public static GamespeedFloatView getInstance() {

		if (mGamespeedFloatViewIntance == null) {

			synchronized (GamespeedFloatView.class) {

				if (mGamespeedFloatViewIntance == null) {

					mGamespeedFloatViewIntance = new GamespeedFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mGamespeedFloatViewIntance;

	}

	private GamespeedFloatView(Context context) {
		super(context);

		mContext = context;
		// 初始化view
		initView();
		setClick();

	}

	private void setClick() {
		subSpeed.setOnClickListener(this);
		andSpeed.setOnClickListener(this);

		reSet.setOnClickListener(this);
		set.setOnClickListener(this);
		speed_text.setOnClickListener(this);
		bgLinearLayout.setOnClickListener(this);

	}

	@Override
	public View getFloatView() {

		if (mView != null) {
			return mView;
		} else {
			mView = LayoutInflater.from(mContext).inflate(
					R.layout.tz_dtcq_gamespeed_float_window_big, null);
			return mView;
		}

	}

	@Override
	public void initView() {
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_gamespeed_float_window_big, null);

		subSpeed = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_sub_image);

		andSpeed = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_and_image);
		reSet = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_reset_image);
		set = (Button) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_set_button);
		speed_text = (TextView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_textView);
		bgLinearLayout= (LinearLayout) mView.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_bg);

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_sub_image) {
			
			if (speed>=1.0f) {
				speed = speed-1.0f;
				speed_text.setText(String.valueOf(speed));
				
				ToastUtils.showToast("减速");
				
			//	Toast.makeText(mContext, "减速", 0).show();
			}else {
				
				ToastUtils.showToast("不能再减了");
			//	Toast.makeText(mContext, "不能再减�?", 0).show();
			}
			

		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_and_image) {

			speed =speed+1.0f;
			speed_text.setText(String.valueOf(speed));
			ToastUtils.showToast("加速");
		//	Toast.makeText(mContext, "加速", 0).show();
		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_reset_image) {
		
			ToastUtils.showToast("重置");
			//Toast.makeText(mContext, "重置", 0).show();
		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_set_button) {
			ToastUtils.showToast("设置");
			//Toast.makeText(mContext, "设置", 0).show();
		}else if (v.getId()== R.id.tz_dtcq_gamespeed_float_window_big_bg) {
			
			MyWindowManager.getInstance(MyFloatServes.mContext).andSetFloatView();
			MyWindowManager.getInstance(MyFloatServes.mContext).removeView(GamespeedFloatView.getInstance().getFloatView());
			Toast.makeText(mContext, "设置隐藏", 0).show();
			
		}

	}
}
