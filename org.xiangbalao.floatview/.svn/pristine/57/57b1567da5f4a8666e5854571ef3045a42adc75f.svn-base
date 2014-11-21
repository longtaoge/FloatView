package com.gamedashi.dtcq.floatview.view;

import com.gamedashi.dtcq.floatview.GlobalParams_float;
import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 附魔属性
 * 
 * @author longtaoger
 * 
 */
public class AdditionFloatView extends BaseFloatView implements OnClickListener {
	private static AdditionFloatView mAdditionIntance;
	// private static View mView;
	// private static ImageView close;

	private  View mView;
	private  ImageView close;

	private AdditionFloatView(Context context) {
		super(context);
		mContext = context;
		initView();
		setClick();

	}

	private void setClick() {

		close.setOnClickListener(this);
	}

	public static AdditionFloatView getInstance() {

		if (mAdditionIntance == null) {

			synchronized (DialogFloatView.class) {

				if (mAdditionIntance == null) {

					mAdditionIntance = new AdditionFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mAdditionIntance;

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
				R.layout.tz_dtcq_addition_float_window, null);
		close = (ImageView) mView
				.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_close);

	}

	@Override
	public void onClick(View v) {
		if (mView.getParent()!=null) {
			remove();
		}
		
	}

}
