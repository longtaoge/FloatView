package com.gamedashi.dtcq.floatview.view;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.adapter.EquipmentGridAdapter;
import com.gamedashi.dtcq.floatview.dao.Equipmen_Dao;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.gamedashi.dtcq.floatview.model.db.Item;

/**
 * 装备图鉴 、装备列表
 * 
 * @author longtaoger
 * 
 */
public class EquipmentListFloatView extends BaseFloatView implements
		OnClickListener, OnItemClickListener, OnCheckedChangeListener {
	private static EquipmentListFloatView mEquipmentListFloatViewIntance;

	private View mView;
	private GridView mGridView;
	private List<Item> mItems;
	private Equipmen_Dao dao;

	private Integer color = 0;
	private Integer type = 0;

	private ImageView mClose;

	private EquipmentGridAdapter mAdapter;

	private RadioButton color_Button1, color_Button2, color_Button3,
			color_Button4, color_Button5, color_Button6, type_Button1,
			type_Button2, type_Button3, type_Button4, type_Button5;

	private EquipmentListFloatView(Context context) {
		super(context);
		mContext = context;
		initView();

	}

	private void setClick() {

		mGridView.setOnItemClickListener(this);
		mClose.setOnClickListener(this);
		color_Button1.setOnCheckedChangeListener(this);
		color_Button2.setOnCheckedChangeListener(this);
		color_Button3.setOnCheckedChangeListener(this);
		color_Button4.setOnCheckedChangeListener(this);
		color_Button5.setOnCheckedChangeListener(this);
		color_Button6.setOnCheckedChangeListener(this);

		type_Button1.setOnCheckedChangeListener(this);
		type_Button2.setOnCheckedChangeListener(this);
		type_Button3.setOnCheckedChangeListener(this);
		type_Button4.setOnCheckedChangeListener(this);
		type_Button5.setOnCheckedChangeListener(this);
	}

	/**
	 * 填充
	 */
	private void fillData() {

		if (mAdapter == null) {
			mAdapter = new EquipmentGridAdapter(mContext, mItems);
		} else {
			mAdapter = null;

			mAdapter = new EquipmentGridAdapter(mContext, mItems);
		}

		if (mGridView != null) {

			mEquipmentListFloatViewIntance.mGridView.setAdapter(mAdapter);

		}

		mEquipmentListFloatViewIntance.mGridView.setOnItemClickListener(this);

	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		dao = Equipmen_Dao.getInstance();
		if (type == 0 & color == 0) {
			mItems = dao.find_all_Item();
			Log.i("click3", mItems.size() + "");
		} else if (type == 0) {

			if (color == 5) {

				mItems = dao.find_by_Color("5");
			} else if (color == 4) {
				mItems = dao.find_by_Color("4");
			} else if (color == 3) {
				mItems = dao.find_by_Color("3");
			} else if (color == 2) {
				mItems = dao.find_by_Color("2");
			} else if (color == 1) {
				mItems = dao.find_by_Color("1");
			}

			Log.i("click2", mItems.size() + "");

		} else if (color == 0) {

			mItems.clear();

			if (type == 1) {
				mItems = dao.find_All_Item_Bytype("1");
			} else if (type == 2) {
				mItems = dao.find_All_Item_Bytype("2");
			} else if (type == 3) {
				mItems = dao.find_All_Item_Bytype("3");
			} else if (type == 4) {
				mItems = dao.find_All_Item_Bytype("4");
			}

		} else {
			mItems.clear();
			mItems = dao.find_by_ColorAndType(String.valueOf(color),
					String.valueOf(type));
		}

	}

	public static EquipmentListFloatView getInstance() {

		if (mEquipmentListFloatViewIntance == null) {

			synchronized (EquipmentListFloatView.class) {

				if (mEquipmentListFloatViewIntance == null) {

					mEquipmentListFloatViewIntance = new EquipmentListFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		mEquipmentListFloatViewIntance.initData();
		mEquipmentListFloatViewIntance.fillData();
		mEquipmentListFloatViewIntance.setClick();

		return mEquipmentListFloatViewIntance;

	}

	@Override
	public View getFloatView() {
		if (mView != null) {
			return mView;
		} else {
			mView = LayoutInflater.from(mContext).inflate(
					R.layout.tz_dtcq_equipment_list_float_window, null);
		}

		return mView;
	}

	@Override
	public void initView() {

		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_equipment_list_float_window, null);

		mGridView = (GridView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_gridView);

		mClose = (ImageView) mView
				.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_close);

		color_Button1 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button1);
		color_Button2 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button2);
		color_Button3 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button3);
		color_Button4 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button4);
		color_Button5 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button5);
		color_Button6 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button6);

		type_Button1 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button1);
		type_Button2 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button2);
		type_Button3 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button3);
		type_Button4 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button4);
		type_Button5 = (RadioButton) mView
				.findViewById(R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button5);

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.tz_dtcq_equip_list_float_window_listview_close) {

			if (mView.getParent() != null) {
				MyWindowManager.getInstance(MyFloatServes.mContext).removeView(
						mView);
			}

		}
	}

	/**
	 * 处理列表项点击事件
	 * 
	 * @param parent
	 * @param view
	 * @param position
	 * @param id
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Log.i("item", position + "<" + id);

		// TODO

		if (mView.getParent() != null) {
			MyWindowManager.getInstance(MyFloatServes.mContext)
					.andEquipmentList_DialogFloatView(
							String.valueOf(mItems.get(position).getId()));
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView.isChecked()) {

			if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button1) {
				color = 0;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button2) {
				color = 5;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button3) {
				color = 4;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button4) {
				color = 3;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button5) {
				color = 2;

			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup1_button6) {
				color = 1;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button1) {
				type = 0;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button2) {
				type = 1;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button3) {
				type = 2;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button4) {
				type = 3;
			} else if (buttonView.getId() == R.id.tz_dtcq_equipment_list_float_window_color_radioGroup2_button5) {
				type = 4;
			}

			initData();
			fillData();
		}

	}

}
