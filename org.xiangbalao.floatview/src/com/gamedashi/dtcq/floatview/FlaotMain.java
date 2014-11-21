package com.gamedashi.dtcq.floatview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.gamedashi.dtcq.floatview.utils.DBUtils;
import com.gamedashi.dtcq.floatview.view.BaseFloatView;

public class FlaotMain extends Activity implements OnClickListener {

	public static Context mContext;
	private ImageButton more;

	List<Map<String, String>> moreList;

	private Button button_copy;

	private PopupWindow pwMyPopWindow;// popupwindow
	private ListView lvPopupList;// popupwindow中的ListView
	private int NUM_OF_VISIBLE_LIST_ROWS = 3;// 指定popupwindow中Item的数量

	public static MyWindowManager myWindowManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tz_dtcq_floatview_activity_main);

		// setContentView(R.layout.test);
		mContext = this;
		inintAll();
	}

	public void inintAll() {
		ininitContext();

		findView();
		copyDb("cards.sqlite", this);

		if (MyFloatServes.mContext != null) {
			// myWindowManager = MyWindowManager
			// .getInstance(MyApplication.mContext);
			myWindowManager = MyWindowManager
					.getInstance(getApplicationContext());

		}

		iniData();
		// mui_FloatWindow();
		// funClick2();
		iniPopupWindow();
	}

	private void ininitContext() {

		MyFloatServes.mContext = this.getApplicationContext();

		MyFloatServes.mWindowManager = (WindowManager) getApplicationContext()
				.getSystemService(Context.WINDOW_SERVICE);
		MyFloatServes.display = MyFloatServes.mWindowManager.getDefaultDisplay();

	}

	@Override
	protected void onResume() {

		super.onResume();
	}

	private void copyDb(String dbName, Context context) {
		DBUtils dbUtils = new DBUtils();
		dbUtils.copyDb(dbName, context);

	}

	private void findView() {
		more = (ImageButton) findViewById(R.id.tz_dtcq_floatview_activity_main_ib_operate_more);
		button_copy = (Button) findViewById(R.id.button_copy);
		more.setOnClickListener(this);

		button_copy.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			mui_FloatWindow();

			myWindowManager.andGamespeedFloatView();

		} else if (v.getId() == R.id.tz_dtcq_floatview_activity_main_ib_operate_more) {

			Toast.makeText(MyFloatServes.mContext, "popwindow", 0).show();

			if (pwMyPopWindow.isShowing()) {

				pwMyPopWindow.dismiss();// 关闭
			} else {

				pwMyPopWindow.showAsDropDown(more);// 显示
			}

		} else if (v.getId() == R.id.button_copy) {

			DBUtils dbUtils = new DBUtils();
			if (dbUtils.install("gamedashi.com.floatView.apk", mContext)) {
				Toast.makeText(mContext, "安装成功", 0).show();
			} else {
				Toast.makeText(mContext, "安装失败", 0).show();
			}

		}
	}

	private void mui_FloatWindow() {
		// 如果是小米，打开悬浮窗口选项
		if (android.os.Build.MODEL.contains("MI 3")) {

			Log.i("mi", android.os.Build.MODEL);

			setfloatWindow();
		}
	}

	/**
	 * 小米系列手机需要判断?
	 */
	private void setfloatWindow() {
		Intent localIntent = new Intent(
				"android.settings.APPLICATION_DETAILS_SETTINGS");
		localIntent.setData(Uri.fromParts("package",
				"com.gamedashi.dtcq.floatview1", null));
		startActivity(localIntent);

	}

	private void funClick2() {
		// 按钮被点击
		this.startService(new Intent(FlaotMain.this, MyFloatServes.class

		));
		Log.i("tz", "funClick5");
		// FlaotMain.this.finish();
	}

	private void iniData() {

		moreList = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		map = new HashMap<String, String>();
		map.put("share_key", "开始");
		moreList.add(map);
		map = new HashMap<String, String>();
		map.put("share_key", "结束");
		moreList.add(map);
		map = new HashMap<String, String>();
		map.put("share_key", "重启");
		moreList.add(map);
	}

	private void iniPopupWindow() {

		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(
				R.layout.tz_dtcq_floatview_task_detail_popupwindow, null);
		lvPopupList = (ListView) layout
				.findViewById(R.id.tz_dtcq_floatview_task_detail_popupwindow_lv_popup_list);
		pwMyPopWindow = new PopupWindow(layout);
		pwMyPopWindow.setFocusable(true);// 加上这个popupwindow中的ListView才可以接收点击事件

		lvPopupList.setAdapter(new SimpleAdapter(FlaotMain.this, moreList,
				R.layout.tz_dtcq_flaotview_list_item_popupwindow,
				new String[] { "share_key" }, new int[] { R.id.tv_list_item }));
		lvPopupList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				switch (position) {
				case 0:

					try {
						// stargame();
						// TODO
						// MyFloatServes.gamePackageName="sh.lilith.dgame.uc";

						MyFloatServes.gamePackageName = "com.gamedashi.dtcq.floatview";
						funClick2();
					} catch (Exception e) {

					}

					break;

				default:
					break;
				}

				// Toast.makeText(MainActivity.this,
				// moreList.get(position).get("share_key"),
				// Toast.LENGTH_LONG).show();
			}

			/**
			 * 启动游戏
			 */
			private void stargame() {
				Intent intent = new Intent();
				// sh.lilith.dgame.uc sh.lilith.dgame.DGame
				// 启动程序
				intent.setComponent(new ComponentName(
						MyFloatServes.gamePackageName, "sh.lilith.dgame.DGame"));
				// intent.setComponent(new
				// ComponentName("com.gamedashi.dtcq.daota.flaoatview","com.gamedashi.dtcq.daota.flaoatview.controller.AboutActivity"));
				intent.setAction(Intent.ACTION_VIEW);
				startActivity(intent);
			}
		});

		// 控制popupwindow的宽度和高度自适应
		lvPopupList.measure(View.MeasureSpec.UNSPECIFIED,
				View.MeasureSpec.UNSPECIFIED);

		// pwMyPopWindow.setWidth(lvPopupList.getMeasuredWidth());
		pwMyPopWindow.setWidth(lvPopupList.getMeasuredWidth());
		// pwMyPopWindow.setHeight((lvPopupList.getMeasuredHeight() + 20)
		// * NUM_OF_VISIBLE_LIST_ROWS);
		//(lvPopupList.getMeasuredHeight()+10 )* moreList.size()
		pwMyPopWindow
				.setHeight((lvPopupList.getMeasuredHeight()+10 )* moreList.size());

		// 控制popupwindow点击屏幕其他地方消失
		pwMyPopWindow.setBackgroundDrawable(this.getResources().getDrawable(
				R.drawable.bg_popupwindow));// 设置背景图片，不能在布局中设置，要通过代码来设置
		pwMyPopWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失。这个要求你的popupwindow要有背景图片才可以成功，如上
	}
}
