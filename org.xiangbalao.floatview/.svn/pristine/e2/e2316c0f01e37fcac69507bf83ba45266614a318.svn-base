package com.gamedashi.dtcq.floatview.utils;

import com.gamedashi.dtcq.floatview.MyFloatServes;

import android.widget.Toast;


public class ToastUtils {

	private static  Toast mToast;

	public static void showToast(String text) {
		
		if (mToast == null) {
			mToast = Toast.makeText(MyFloatServes.mContext, text,
					Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	public void cancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}

}
