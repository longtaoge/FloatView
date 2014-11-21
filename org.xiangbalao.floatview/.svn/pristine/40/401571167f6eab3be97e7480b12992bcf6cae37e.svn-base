package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;

/**
 * 呼出英雄图鉴
 * 
 * @author longtaoger
 * 
 */
public class Hero_Card_FloatView extends BaseFloatView implements
		OnClickListener {

	private static Hero_Card_FloatView mHero_Card_FloatViewIntance;
	private static View mView;

	private Hero_Card_FloatView(Context context) {
		super(context);
		mContext = context;
		initView();
	}

	public static Hero_Card_FloatView getInstance() {

		if (mHero_Card_FloatViewIntance == null) {

			synchronized (Hero_Card_FloatView.class) {

				if (mHero_Card_FloatViewIntance == null) {

					mHero_Card_FloatViewIntance = new Hero_Card_FloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mHero_Card_FloatViewIntance;

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
		mView = new View(mContext);
		mView.setBackgroundDrawable(mContext.getResources().getDrawable(
				R.drawable.tz_dtcq_float_window_hero_card));

		mView.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (mView.getParent()!=null) {
			remove();
		}
		
		MyWindowManager.getInstance(mContext).andDialogFloatView();

	}

}
