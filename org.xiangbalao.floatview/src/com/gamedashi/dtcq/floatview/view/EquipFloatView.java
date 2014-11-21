package com.gamedashi.dtcq.floatview.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;

/**
 * 呼出装备图鉴
 * 
 * @author longtaoger
 * 
 */
public class EquipFloatView extends BaseFloatView implements OnClickListener {

	private static EquipFloatView mEquipFloatViewIntance;
	private View mView;

	public static EquipFloatView getInstance() {

		if (mEquipFloatViewIntance == null) {

			synchronized (Hero_Card_FloatView.class) {

				if (mEquipFloatViewIntance == null) {

					mEquipFloatViewIntance = new EquipFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mEquipFloatViewIntance;

	}

	private EquipFloatView(Context context) {
		super(context);
		mContext = context;
		initView();
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
				R.drawable.tz_dtcq_float_window_equip_card));
		mView.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		Toast.makeText(MyFloatServes.mContext, "取消", 0).show();

		if (mView.getParent() != null) {

			remove();
		}

		MyWindowManager.getInstance(MyFloatServes.mContext)
				.andEquipmentListFloatView();

	}

}
