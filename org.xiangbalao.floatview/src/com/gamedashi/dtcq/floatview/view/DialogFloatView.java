package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;

/**
 * 全英雄图鉴功能对话框
 * 
 * @author longtaoger
 * 
 */
public class DialogFloatView extends BaseFloatView implements OnClickListener {
	private static DialogFloatView mDialogFloatViewIntance;

	private TextView gowatch, cancel;
	private View mView;

	private DialogFloatView(Context context) {
		super(context);
		mContext = context;

		initView();

	}

	public static DialogFloatView getInstance() {

		if (mDialogFloatViewIntance == null) {

			synchronized (DialogFloatView.class) {

				if (mDialogFloatViewIntance == null) {

					mDialogFloatViewIntance = new DialogFloatView(
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
				R.layout.tz_dtcq_dialog_float_window, null);
		gowatch = (TextView) mView
				.findViewById(R.id.tz_dtcq_dialog_float_window_title_gowatch);
		gowatch.setOnClickListener(this);
		cancel = (TextView) mView
				.findViewById(R.id.tz_dtcq_dialog_float_window_cancel);
		cancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tz_dtcq_dialog_float_window_title_gowatch) {

			// TODO 处理点击事件

			Toast.makeText(MyFloatServes.mContext, "去大师查看", 0).show();

		} else if (v.getId() == R.id.tz_dtcq_dialog_float_window_cancel) {
			Toast.makeText(MyFloatServes.mContext, "取消", 0).show();
			
			if (mView.getParent()!=null) {
				
			
				remove();
			}
			
			

		}

	}

}
