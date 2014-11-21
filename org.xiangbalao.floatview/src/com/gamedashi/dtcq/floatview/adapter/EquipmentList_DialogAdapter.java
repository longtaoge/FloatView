package com.gamedashi.dtcq.floatview.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.adapter.E_G_Adapter1;
import com.gamedashi.dtcq.floatview.model.db.Cards;
import com.gamedashi.dtcq.floatview.model.db.Item;
import com.gamedashi.dtcq.floatview.model.db.Pass;

/**
 * 
 * 
 * @author longtaoger
 * 
 */
public class EquipmentList_DialogAdapter extends MyBaseAdapter {
	private static Context mContext;
	private static List<Item> mainid_list;
	private static List<Item> subid_list;
	private static List<Pass> pass_list;
	private static List<Cards> card_icon_list;

	public EquipmentList_DialogAdapter(Context mContext) {
	}

	public EquipmentList_DialogAdapter(Context mContext,
			List<Item> mainid_list, List<Item> subid_list,
			List<Pass> pass_list, List<Cards> card_icon_list) {

		this.mContext = mContext;
		this.mainid_list = mainid_list;
		this.subid_list = subid_list;
		this.pass_list = pass_list;
		this.card_icon_list = card_icon_list;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Object getItem(int position) {

		switch (position) {
		case 0:
			return mainid_list;
		case 1:
			return subid_list;
		case 2:
			return pass_list;
		case 3:
			return card_icon_list;
		default:
			break;
		}

		return null;

	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View itemView = null;
		switch (position) {
		case 0:

			itemView = View
					.inflate(
							mContext,
							R.layout.tz_dtcq_equipment_list_dialog_box_float_window_listitem1,
							null);
			TextView mTextView = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_griditem1_des);
			mTextView.setText("可合成\t");
			GridView mGridView = (GridView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_griditem1_gridView);

			E_G_Adapter1 mE_G_Adapter = new E_G_Adapter1(mContext, mainid_list);

			mGridView.setAdapter(mE_G_Adapter);

			break;
		case 1:

			itemView = View
					.inflate(
							mContext,
							R.layout.tz_dtcq_equipment_list_dialog_box_float_window_listitem1,
							null);

			mTextView = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_griditem1_des);
			mTextView.setText("合成材料");
			mGridView = (GridView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_griditem1_gridView);

			mE_G_Adapter = new E_G_Adapter1(mContext, subid_list);

			mGridView.setAdapter(mE_G_Adapter);

			break;

		case 2:
			itemView = View
					.inflate(
							mContext,
							R.layout.tz_dtcq_equipment_list_dialog_box_float_window_listitem3,
							null);

			TextView mTextView2 = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_griditem3_text);

			if (pass_list.size() > 0) {

				String temppass = "";

				Map<String, String> mMap = new HashMap<String, String>();

				for (int i = 0; i < pass_list.size(); i++) {

					mMap.put(pass_list.get(i).getName(), pass_list.get(i)
							.getName());

				}

				for (String key : mMap.keySet()) {

					temppass = temppass + key + "\n";
				}

				mTextView2.setText(temppass);

			} else {

				mTextView2.setText("抽奖获得");
			}

			break;

		case 3:

			itemView = View
					.inflate(
							mContext,
							R.layout.tz_dtcq_equipment_list_dialog_box_float_window_listitem4,
							null);

			E_G_Adapter4 mE_G_Adapter4 = new E_G_Adapter4(mContext,
					card_icon_list);
			mGridView = (GridView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_griditem3_gridView);

			mGridView.setAdapter(mE_G_Adapter4);

			break;
		default:
			break;
		}

		return itemView;
	}

}
