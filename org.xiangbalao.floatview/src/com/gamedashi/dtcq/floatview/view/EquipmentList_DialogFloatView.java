package com.gamedashi.dtcq.floatview.view;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.adapter.EquipmentList_DialogAdapter;
import com.gamedashi.dtcq.floatview.dao.Equipmen_Dao;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.gamedashi.dtcq.floatview.model.db.Cards;
import com.gamedashi.dtcq.floatview.model.db.Item;
import com.gamedashi.dtcq.floatview.model.db.Pass;

/**
 * 装备列表弹出框
 * 
 * @author longtaoger
 * 
 */
public class EquipmentList_DialogFloatView extends BaseFloatView implements
		OnClickListener {

	private static EquipmentList_DialogFloatView mEquipmentList_Dialog_Intance;

	private ImageView mClose, icon;
	private ListView mListView;
	private static String mItemId = "";
	private View mView;
	private TextView title, price, mingrade, des, effect;

	private Item mItem;

	// 可合成
	public List<Item> mainid_list;
	// 合成材料
	public List<Item> subid_list;
	// 获得途径
	public List<Pass> pass_list;
	// 装备英雄
	public List<Cards> card_icon_list;

	private EquipmentList_DialogFloatView(Context context, String mItemId) {
		super(context);

		this.mItemId = mItemId;
		mContext = context;
		initData(mItemId);
		initView();
		fillData();

	}

	private void fillData() {

		if (mListView != null) {

			EquipmentList_DialogAdapter mEquipmentList_DialogAdapter = new EquipmentList_DialogAdapter(
					mContext, mainid_list, subid_list, pass_list,
					card_icon_list);
			mListView.setAdapter(mEquipmentList_DialogAdapter);
		}

		imageLoader.displayImage(mItem.getIcon(), icon, options);
		title.setText(mItem.getName());
		price.setText("售价：" + String.valueOf(mItem.getPrice()));
		mingrade.setText("装备等级:" + String.valueOf(mItem.getMinGrade()));
		des.setText(mItem.getDescription());
		String effectHtml;
		if (mItem.getEnchant().length() > 0) {
			effectHtml = convert(mItem.getEnchant());

			effect.setText(Html.fromHtml(effectHtml));
			// Log.i("effect", effectHtml);

		} else {
			effectHtml = mItem.getEffect().replace("、", "\n");
			effect.setText(effectHtml);
			// Log.i("effect1", effectHtml);
		}

	}

	/**
	 * 转换HTML
	 * 
	 * @param effects
	 * @return
	 */
	private String convert(String effects) {
		String emphtml = "";
		String temphtml = "";
		Log.i("temphtml_le11", effects);
		String mEnchant = effects.replace("（", "(").replace("）", ")");

		String leftHtml = "<font color='#D4CBB5'>&&&&</font>";
		String rightHtml = "<font color='#4BD500'>(&&&&</font><br/><br/>";
		// 所有附魔属性
		String[] mList;
		mList = mEnchant.split("、");

		for (int i = 0; i < mList.length; i++) {
			String tempall = mList[i].trim();

			String[] tempArray = tempall.split("\\(");
			String templef = tempArray[0];

			temphtml = temphtml + leftHtml.replace("&&&&", templef);

			if (tempArray.length >= 2) {
				Log.i("temphtml_le", String.valueOf(tempArray.length));

				String tempRight = tempArray[1];

				temphtml = temphtml + rightHtml.replace("&&&&", tempRight);
			}

		}

		temphtml = temphtml
				+ "<font color='#4BD500'>括号内为附魔满级属性</font><br/><br/>";
		// mTextView.setText(Html.fromHtml(temphtml.trim()));
		Log.i("temphtml_le", temphtml);
		return temphtml.trim();
	}

	/**
	 * 初始化数据
	 * 
	 */
	private void initData(String mItemID) {
		// TODO 修改传入参数
		this.mItemId = mItemID;

		Equipmen_Dao dao = Equipmen_Dao.getInstance();
		mainid_list = dao.findMainidBySubid(mItemId);
		subid_list = dao.findSubidByMainid(mItemId);
		pass_list = dao.findPassByItem(mItemId);
		card_icon_list = dao.findCardsByItem(mItemId);
		mItem = dao.find_Item_ByID(mItemId);

	}

	public static EquipmentList_DialogFloatView getInstance(String mItemID) {

		if (mEquipmentList_Dialog_Intance == null) {

			synchronized (SetFloatView.class) {

				if (mEquipmentList_Dialog_Intance == null) {

					mEquipmentList_Dialog_Intance = new EquipmentList_DialogFloatView(
							MyFloatServes.mContext, mItemID);

				}

			}

		} else {

			mEquipmentList_Dialog_Intance.mItemId = mItemID;

			mEquipmentList_Dialog_Intance.initData(mItemId);

			mEquipmentList_Dialog_Intance.fillData();

		}

		return mEquipmentList_Dialog_Intance;

	}

	@Override
	public View getFloatView() {

		if (mView != null) {
			return mView;
		} else {
			mView = LayoutInflater.from(mContext).inflate(
					R.layout.tz_dtcq_equipment_list_dialog_box_float_window,
					null);
			return mView;
		}
	}

	@Override
	public void initView() {

		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_equipment_list_dialog_box_float_window, null);
		mClose = (ImageView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_close);
		mClose.setOnClickListener(this);

		mListView = (ListView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_listView);
		title = (TextView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_title);
		mingrade = (TextView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_title2);
		des = (TextView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_title3);

		price = (TextView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_price);
		icon = (ImageView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_icon);
		effect = (TextView) mView
				.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_destextView1);
		
		
		
		

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tz_dtcq_equipment_list_dialog_box_float_window_close) {

			if (mView.getParent() != null) {
				MyWindowManager.getInstance(MyFloatServes.mContext).removeView(
						mView);
			}

		}

	}

}
