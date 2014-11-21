package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.gamedashi.dtcq.floatview.utils.ToastUtils;
//import com.gamedashi.dtcq.hookApi.HookAPI;

/**
 * 底部加速控制台 版本2
 * 
 * @author longtaoger
 * 
 */
public class GamespeedFloatView_one extends BaseFloatView implements
		OnClickListener, OnCheckedChangeListener {

	private static ImageView subSpeed, andSpeed, reSet;
	private LinearLayout bgLinearLayout;
	private CheckBox mCheckBox;
	private static ImageButton about;
	// private static Float speed = 1.0f;
	public static TextView speed_text;

	private static GamespeedFloatView_one mGamespeedFloatViewIntance_one;
	public static View mView;

	public static GamespeedFloatView_one getInstance() {

		if (mGamespeedFloatViewIntance_one == null) {

			synchronized (GamespeedFloatView_one.class) {

				if (mGamespeedFloatViewIntance_one == null) {

					mGamespeedFloatViewIntance_one = new GamespeedFloatView_one(
							MyFloatServes.mContext);

				}

			}

		} else {
			
			//mGamespeedFloatViewIntance_one.speed_text.setText(String
				//	.valueOf(MyFloatServes.game_speed));
			/**
			 * 每次启动页面时显示的速度
			 */
			mGamespeedFloatViewIntance_one.speed_text.setText("0.0");
			
			mGamespeedFloatViewIntance_one.speed_text.invalidate();
			
		}

		return mGamespeedFloatViewIntance_one;

	}

	private GamespeedFloatView_one(Context context) {
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
		about.setOnClickListener(this);
		speed_text.setOnClickListener(this);
		bgLinearLayout.setOnClickListener(this);
		mCheckBox.setOnCheckedChangeListener(this);

	}

	@Override
	public View getFloatView() {

		if (mView != null) {
			return mView;
		} else {
			mView = LayoutInflater.from(mContext).inflate(
					R.layout.tz_dtcq_gamespeed_float_window_big_one, null);
			return mView;
		}

	}

	@Override
	public void initView() {
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_gamespeed_float_window_big_one, null);

		subSpeed = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_sub_one_image);

		andSpeed = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_and_one_image);
		reSet = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_reset_one_image);
		about = (ImageButton) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_about_button);
		speed_text = (TextView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_one_textView);

		bgLinearLayout = (LinearLayout) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_big_one_bg);

		mCheckBox = (CheckBox) mView
				.findViewById(R.id.z_dtcq_gamespeed_float_window_big_onekeyexit);

		setOneKeyExit();

	}

	/**
	 * 一键退出
	 */
	public void setOneKeyExit() {

		MyFloatServes.sp = MyFloatServes.mContext
				.getSharedPreferences(MyFloatServes.SP_NAME, 0);

		MyFloatServes.onekeyexit = MyFloatServes.sp.getBoolean(
				MyFloatServes.NOEKEYEXIT, true);

		if (MyFloatServes.onekeyexit) {

			mCheckBox.setText(" 开");
			mCheckBox.setChecked(true);

		} else {
			mCheckBox.setChecked(false);
			mCheckBox.setText(" 关");
		}
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_sub_one_image) {

			// 0.25 0.5 0.0 1.0

			if (MyFloatServes.game_speed <= -2.0f) {
				MyFloatServes.game_speed = -2.0f;
			} else {
				MyFloatServes.game_speed = MyFloatServes.game_speed - 1.0f;
			}

			changespeed2(MyFloatServes.game_speed);

			// Toast.makeText(mContext, "减速", 0).show();

		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_and_one_image) {

			if (MyFloatServes.game_speed >= 1.0f) {
				MyFloatServes.game_speed = 1.0f;

			} else {

				MyFloatServes.game_speed = MyFloatServes.game_speed + 1.0f;
			}

			changespeed2(MyFloatServes.game_speed);

		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_reset_one_image) {

			MyFloatServes.game_speed = 0.0f;

			changespeed2(MyFloatServes.game_speed);

			// Toast.makeText(mContext, "重置", 0).show();

			// HookAPI.setSpeedValue(String.valueOf(MyFloatServes.game_speed));

			// Log.i("hook2_gamespeed_reset",
			// String.valueOf(MyFloatServes.game_speed));
			// ToastUtils.showToast("重置");
			// Toast.makeText(mContext, "重置", 0).show();

		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_one_bg) {

			MyWindowManager.getInstance(MyFloatServes.mContext)
					.andSetFloatView();
			MyWindowManager
					.getInstance(MyFloatServes.mContext)
					.removeView(
							GamespeedFloatView_one.getInstance().getFloatView());
			// Toast.makeText(mContext, "设置隐藏", 0).show();

		} else if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_big_about_button) {

			MyWindowManager.getInstance(MyFloatServes.mContext)
					.andRecruitDialogFloatView();

		}

	}

	private void changespeed2(Float game_speed) {

		if (MyFloatServes.game_speed == -2.0f) {

			// Toast.makeText(mContext, "-2.0**" +
			// MyFloatServes.game_speed+0.25f, 0)
			// .show();
			//HookAPI.setSpeedValue(String.valueOf(0.25f));

		} else if (MyFloatServes.game_speed == -1.0f) {

			// Toast.makeText(mContext, "-1.0**" +
			// MyFloatServes.game_speed+0.5f, 0)
			// .show();
			//HookAPI.setSpeedValue(String.valueOf(0.5f));

		} else if (MyFloatServes.game_speed == 0.0f) {
			// Toast.makeText(mContext, "0.0**" +
			// MyFloatServes.game_speed+1.0f,
			// 0)
			// .show();
			//HookAPI.setSpeedValue(String.valueOf(1.0f));
		} else if (MyFloatServes.game_speed == 1.0f) {

			// Toast.makeText(mContext, "1.0**" +
			// MyFloatServes.game_speed+2.0f,
			// 0)
			// .show();

			//HookAPI.setSpeedValue(String.valueOf(2.0f));
		}

		speed_text.setText(String.valueOf(MyFloatServes.game_speed));
		speed_text.invalidate();
	}

	/**
	 * 除2算法
	 * 
	 */
	public void changespeed() {

		if (MyFloatServes.game_speed < 0.0f) {
			if (MyFloatServes.game_speed >= 0.25f) {
				speed_text.setText(String.valueOf("-" + 0.5f
						/ MyFloatServes.game_speed));
			} else {

				MyFloatServes.game_speed = 0.25f;
				speed_text.setText(String.valueOf("-" + 0.5f
						/ MyFloatServes.game_speed));

			}

		} else {

			if (MyFloatServes.game_speed >= 0.1f) {
				if (MyFloatServes.game_speed > 1.0f) {

					MyFloatServes.game_speed = 1.0f;

				} else {
					MyFloatServes.game_speed = 1.0f;
				}

				speed_text.setText(String
						.valueOf(MyFloatServes.game_speed));
			}

		}

		speed_text.invalidate();
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView.getId() == R.id.z_dtcq_gamespeed_float_window_big_onekeyexit) {

			// HookAPI.setExit();

			if (mCheckBox.isChecked()) {

				MyFloatServes.sp = MyFloatServes.mContext
						.getSharedPreferences(MyFloatServes.SP_NAME, 0);
				MyFloatServes.sp.edit().putBoolean("noekeyexit", true)
						.commit();

				MyFloatServes.onekeyexit = true;
				MyWindowManager.getInstance(MyFloatServes.mContext)
						.andExitFloatView();

				mCheckBox.setText(" 开");

				// Toast.makeText(mContext,
				// "开启一键退出" + MyFloatServes.onekeyexit, 0).show();

			} else {

				MyFloatServes.sp = MyFloatServes.mContext
						.getSharedPreferences(MyFloatServes.SP_NAME, 0);
				MyFloatServes.sp.edit().putBoolean("noekeyexit", false)
						.commit();
				MyFloatServes.onekeyexit = false;
				MyWindowManager.getInstance(MyFloatServes.mContext)
						.removeView(ExitFloatView.getInstance().getFloatView());
				mCheckBox.setText(" 关");
				// Toast.makeText(mContext,
				// "关闭一键退出" + MyFloatServes.onekeyexit, 0).show();
			}

		}

	}
}
