package com.gamedashi.dtcq.floatview.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.StringTokenizer;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
//import com.gamedashi.dtcq.hookApi.HookAPI;
//import com.gamedashi.dtcq.hookApi.MyThread;

/**
 * 退出按钮
 * 
 * @author longtaoger
 * 
 */
public class ExitFloatView extends BaseFloatView implements OnClickListener {
	private static KillThead mKillThead = null;
	private static ExitFloatView mExitFloatViewIntance;
	private View mView;

	private LinearLayout mLinearLayout;

	private ExitFloatView(Context context) {
		super(context);
		mContext = context;
		// 初始化view
		initView();
	}

	public static ExitFloatView getInstance() {

		if (mExitFloatViewIntance == null) {

			synchronized (ExitFloatView.class) {

				if (mExitFloatViewIntance == null) {

					mExitFloatViewIntance = new ExitFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mExitFloatViewIntance;

	}

	@Override
	public View getFloatView() {

		if (mView != null) {
			return mView;
		} else {
			mView = LayoutInflater.from(mContext).inflate(
					R.layout.tz_dtcq_gamespeed_float_window_small_quit, null);
			return mView;
		}
	}

	@Override
	public void initView() {
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_gamespeed_float_window_small_quit, null);
		mLinearLayout = (LinearLayout) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_small_quit_image);

	//	mView.setOnClickListener(this);
		//mLinearLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		// TODO 处理点击事件
		MyFloatServes.game_speed = 0.0f;

		// killProcess(MyFloatServes.gamePackageName);
		// Toast.makeText(MyFloatServes.mContext, "结束", 0).show();

		mKillThead = new KillThead();
		mKillThead.start();

		MyFloatServes.isbegein = false;

		MyFloatServes.startHook = false;

		// Toast.makeText(mContext, "HookAPI.setExit()", 0).show();

		// mMyWindowManager.removeView(GamespeedFloatView.getInstance()
		// .getFloatView());

		// mMyWindowManager.removeView(GamespeedFloatView_one.getInstance()
		// .getFloatView());

		// mMyWindowManager.removeView(SetFloatView.getInstance().getFloatView());
		// mMyWindowManager.removeView(ExitFloatView.getInstance().getFloatView());

	}

	/**
	 * 杀进程
	 */
	private void mykillProcess(String pagename) {

		ActivityManager am = (ActivityManager) MyFloatServes.mContext
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> infos = am.getRunningAppProcesses();
		for (RunningAppProcessInfo info : infos) {

			if (pagename.equals(info.processName)) {

				try {
					killProcess(info.pid);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				break;
			}
		}

	}

	private void killProcess(int processId) throws InterruptedException {
		java.lang.Process process = null;
		try {
			process = Runtime.getRuntime().exec("su");
			OutputStream os = process.getOutputStream();
			os.write(("kill_processid " + processId).getBytes());
			os.flush();
			os.close();
			Thread.sleep(3000); // 这里的sleep的目的让上面的kill命令执行完成
		} catch (IOException ex) {
			Log.e("kill", "" + ex.getStackTrace());
		} finally {
			if (process != null) {
				process.destroy();
				process = null;
			}
		}
	}

	public static void killProcess(String packageName) {
		Log.i("kill_process", "killProcess");
		java.lang.Process process = null;
		try {
			String processId = "";
			process = Runtime.getRuntime().exec("su");
			OutputStream os = process.getOutputStream();
			os.write("ps \n".getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String inline;
			while ((inline = br.readLine()) != null) {
				if (inline.contains(packageName)) {
					Log.i("kill_inline", "" + inline);
					StringTokenizer processInfoTokenizer = new StringTokenizer(
							inline);
					int count = 0;
					while (processInfoTokenizer.hasMoreTokens()) {
						count++;
						processId = processInfoTokenizer.nextToken();
						if (count == 2) {
							break;
						}
					}
					Log.i("kill_processid", "kill process : " + processId);
					os.write(("kill " + processId).getBytes());
					os.flush();
					if (os != null) {
						os.close();
						os = null;
					}
					br.close();
					return;
				}
			}
		} catch (IOException ex) {
			Log.e("kill", "" + ex.getStackTrace());
		} finally {
			if (process != null) {
				process.destroy();
				process = null;
			}
		}
	}

	public class KillThead extends Thread {

		@Override
		public void run() {

			Log.i("kill", MyFloatServes.gamePackageName);

			killProcess(MyFloatServes.gamePackageName);
			// runOnUiThread(new Runnable() {
			// @Override
			// public void run() {
			//
			//
			//
			// Toast.makeText(MyFloatServes.mContext,
			// "kill	Tead", 0).show();
			//
			// }
			// });

		//	HookAPI.setExit();

			// Log.i("speed_EXIT","HOOKEXIT" );
			super.run();
		}

	}

}
