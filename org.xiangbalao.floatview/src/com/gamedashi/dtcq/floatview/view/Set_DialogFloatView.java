package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.ui.button.OnToggleStateChangedListener;
import com.gamedashi.dtcq.floatview.ui.button.SlideButton;

/**
 * 设置对话框
 * 
 * @author longtaoger
 * 
 */
public class Set_DialogFloatView extends BaseFloatView implements
		OnClickListener {

	private static Set_DialogFloatView mDialogFloatViewIntance;
	private View mView;
	private SlideButton slideButton1, slideButton2, slideButton3, slideButton4,
			slideButton5;

	private LinearLayout mbgLinearLayout;

	private Set_DialogFloatView(Context context) {
		super(context);
		mContext = context;
		initView();
		setClick();

	}

	private void setClick() {
		slideButton1
				.setOnToggleStateChangedListener(new OnToggleStateChangedListener() {

					@Override
					public void onToggleStateChanged(boolean state) {
						if (state) {
							Toast.makeText(mContext, "开", 0).show();
						} else {
							Toast.makeText(mContext, "关", 0).show();
						}

					}
				});

		slideButton2
				.setOnToggleStateChangedListener(new OnToggleStateChangedListener() {

					@Override
					public void onToggleStateChanged(boolean state) {
						if (state) {
							Toast.makeText(mContext, "开", 0).show();
						} else {
							Toast.makeText(mContext, "关", 0).show();
						}

					}
				});

		slideButton3
				.setOnToggleStateChangedListener(new OnToggleStateChangedListener() {

					@Override
					public void onToggleStateChanged(boolean state) {
						if (state) {
							Toast.makeText(mContext, "开", 0).show();
						} else {
							Toast.makeText(mContext, "关", 0).show();
						}

					}
				});

		slideButton4
				.setOnToggleStateChangedListener(new OnToggleStateChangedListener() {

					@Override
					public void onToggleStateChanged(boolean state) {
						if (state) {
							Toast.makeText(mContext, "开", 0).show();
						} else {
							Toast.makeText(mContext, "关", 0).show();
						}

					}
				});

		slideButton5
				.setOnToggleStateChangedListener(new OnToggleStateChangedListener() {

					@Override
					public void onToggleStateChanged(boolean state) {
						if (state) {
							Toast.makeText(mContext, "开", 0).show();
						} else {
							Toast.makeText(mContext, "关", 0).show();
						}

					}
				});

		mbgLinearLayout.setOnClickListener(this);

	}

	public static Set_DialogFloatView getInstance() {

		if (mDialogFloatViewIntance == null) {

			synchronized (Set_DialogFloatView.class) {

				if (mDialogFloatViewIntance == null) {

					mDialogFloatViewIntance = new Set_DialogFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mDialogFloatViewIntance;

	}

	@Override
	public View getFloatView() {

		if (mView != null) {
			return mView;
		} else {
			initView();
		}
		return mView;
	}

	@Override
	public void initView() {
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_gamespeed_float_window_set_dialog, null);
		slideButton1 = (SlideButton) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_set_dialog_slidebutton1);
		slideButton2 = (SlideButton) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_set_dialog_slidebutton2);
		slideButton3 = (SlideButton) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_set_dialog_slidebutton3);
		slideButton4 = (SlideButton) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_set_dialog_slidebutton4);
		slideButton5 = (SlideButton) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_set_dialog_slidebutton5);
		mbgLinearLayout = (LinearLayout) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_set_dialog_bg);

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_set_dialog_bg) {
			
			if (mView.getParent()!=null) {
				remove();
			}
			
			
			Toast.makeText(mContext, "退出设置功能", 0).show();

		}

	}

}
