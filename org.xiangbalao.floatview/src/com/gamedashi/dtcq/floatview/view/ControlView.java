package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;

/**
 * 调试窗口
 * 
 * @author longtaoger
 * 
 */
public class ControlView extends BaseFloatView implements OnClickListener {

	private View mControlView;

	private View mView;

	private Button button1, button2, button3, button4, button5,
			recruit_Dialog_Button, set_Dialog, hero, equip, equiplist, dialog,
			equipmentlist, equipmentlist_dialog, add;
	private int ScreenWidth;
	private int ScreenHeight;
	private WindowManager mWindowManager;

	protected static WindowManager.LayoutParams mLayoutParams_GameSpeed;

	public static MyWindowManager myWindowManager;

	public ControlView(Context context) {
		super(context);
		mContext = context;
		initView();
		findView();
		// start();

		if (MyFloatServes.mContext != null) {
			myWindowManager = MyWindowManager
					.getInstance(MyFloatServes.mContext);

		}
		myWindowManager = MyWindowManager.getInstance(MyFloatServes.mContext);
	}

	public void startSpeed() {

		mWindowManager = MyFloatServes.mWindowManager;

		myWindowManager.start();

	}

	/**
	 * 开始调试
	 */
	public void start() {

		mWindowManager = MyFloatServes.mWindowManager;

		ScreenWidth = MyFloatServes.display.getWidth();

		ScreenHeight = MyFloatServes.display.getHeight();

		if (mLayoutParams_GameSpeed == null) {
			mLayoutParams_GameSpeed = new WindowManager.LayoutParams();
		}

		mLayoutParams_GameSpeed.type = WindowManager.LayoutParams.TYPE_PHONE;
		mLayoutParams_GameSpeed.flags = 40;
		mLayoutParams_GameSpeed.format = -3;

		mLayoutParams_GameSpeed.width = WindowManager.LayoutParams.MATCH_PARENT;
		mLayoutParams_GameSpeed.height = WindowManager.LayoutParams.WRAP_CONTENT;

		mControlView = getFloatView();
		mLayoutParams_GameSpeed.y = ScreenHeight;

		if (mWindowManager != null) {
			try {
				if (mControlView.getParent() == null) {
					mWindowManager.addView(mControlView,
							mLayoutParams_GameSpeed);
				}

			} catch (Exception e) {
				mWindowManager.addView(mControlView, mLayoutParams_GameSpeed);
			}

		} else {
			mWindowManager = (WindowManager) mContext
					.getSystemService(Context.WINDOW_SERVICE);

			mWindowManager.addView(mControlView, mLayoutParams_GameSpeed);
		}

	}

	private void findView() {
		// TODO

		button1 = (Button) mView.findViewById(R.id.button1);
		button1.setOnClickListener(this);

		button2 = (Button) mView.findViewById(R.id.button2);
		button2.setOnClickListener(this);

		button3 = (Button) mView.findViewById(R.id.button3);
		button3.setOnClickListener(this);

		button4 = (Button) mView.findViewById(R.id.button4);
		button4.setOnClickListener(this);

		button5 = (Button) mView.findViewById(R.id.button5);
		button5.setOnClickListener(this);

		recruit_Dialog_Button = (Button) mView
				.findViewById(R.id.recruit_dialog);
		recruit_Dialog_Button.setOnClickListener(this);

		set_Dialog = (Button) mView.findViewById(R.id.set_dialog);
		set_Dialog.setOnClickListener(this);

		hero = (Button) mView.findViewById(R.id.hero);
		hero.setOnClickListener(this);

		equip = (Button) mView.findViewById(R.id.equip);
		equip.setOnClickListener(this);

		equiplist = (Button) mView.findViewById(R.id.equiplist);
		equiplist.setOnClickListener(this);

		dialog = (Button) mView.findViewById(R.id.mydialog);
		dialog.setOnClickListener(this);

		equipmentlist = (Button) mView.findViewById(R.id.equipmentlist);
		equipmentlist.setOnClickListener(this);

		equipmentlist_dialog = (Button) mView
				.findViewById(R.id.equipmentlist_dialog);
		equipmentlist_dialog.setOnClickListener(this);

		add = (Button) mView.findViewById(R.id.add);
		add.setOnClickListener(this);

	}

	@Override
	public View getFloatView() {
		if (mView != null) {
			return mView;
		} else {
			initView();
			return mView;
		}

	}

	@Override
	public void initView() {
		// R.layout.tz_dtcq_floatview_activity_main
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_floatview_activity_control, null);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			// 如果是小米，打开悬浮窗口选项
			if (android.os.Build.MODEL.contains("MI 3")) {

				Log.i("mi", android.os.Build.MODEL);
				// 如果是小米，打开悬浮窗口选项
				// setfloatWindow();
			}
			// funClick();
			myWindowManager.start();
			// myWindowManager.andGamespeedFloatView();

		} else if (v.getId() == R.id.button2) {

			// TODO 处理结束
			if (mControlView.getParent() != null) {
				myWindowManager.removeView(mControlView);
				MyFloatServes.isbegein = false;
			}

		} else if (v.getId() == R.id.button3) {

			// 重启
			MyWindowManager.andGamespeedFloatView();

		} else if (v.getId() == R.id.button4) {

			myWindowManager.andExitFloatView();
		} else if (v.getId() == R.id.button5) {

			myWindowManager.andSetFloatView();
		} else if (v.getId() == R.id.recruit_dialog) {
			// Toast.makeText(mContext, "recruit_dialog", 0).show();
			myWindowManager.andRecruitDialogFloatView();
		} else if (v.getId() == R.id.set_dialog) {

			myWindowManager.andSetDialogFloatView();
		} else if (v.getId() == R.id.hero) {

			myWindowManager.andHero_Card_FloatView();
		} else if (v.getId() == R.id.equip) {

			myWindowManager.andHeroEquipFloatView();

		} else if (v.getId() == R.id.equiplist) {
			myWindowManager.andHeroEquipListFloatView();

		} else if (v.getId() == R.id.mydialog) {

			myWindowManager.andDialogFloatView();

		} else if (v.getId() == R.id.equipmentlist) {
			myWindowManager.andEquipmentListFloatView();

		} else if (v.getId() == R.id.equipmentlist_dialog) {
			myWindowManager.andEquipmentList_DialogFloatView("35");

		} else if (v.getId() == R.id.add) {
			Toast.makeText(mContext, "andAdditionFloatView", 0).show();
			myWindowManager.andAdditionFloatView();
		}

	}

	public void close() {

		mWindowManager = MyFloatServes.mWindowManager;

		ScreenWidth = MyFloatServes.display.getWidth();

		ScreenHeight = MyFloatServes.display.getHeight();

		if (mLayoutParams_GameSpeed == null) {
			mLayoutParams_GameSpeed = new WindowManager.LayoutParams();
		}

		mLayoutParams_GameSpeed.type = WindowManager.LayoutParams.TYPE_PHONE;

		mControlView = getFloatView();
		mLayoutParams_GameSpeed.y = ScreenHeight;

		if (mWindowManager != null) {

			// TODO 移除

			myWindowManager.getInstance(mContext).removeView(
					SetFloatView.getInstance().getFloatView());
		} else {
			mWindowManager = (WindowManager) mContext
					.getSystemService(Context.WINDOW_SERVICE);

			myWindowManager.getInstance(mContext).removeView(
					SetFloatView.getInstance().getFloatView());
		}

	}

}
