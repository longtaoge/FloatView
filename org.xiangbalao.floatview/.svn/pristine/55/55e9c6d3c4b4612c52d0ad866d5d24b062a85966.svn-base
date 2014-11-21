package com.gamedashi.dtcq.floatview.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.adapter.EquipListAdapter;
import com.gamedashi.dtcq.floatview.dao.Cards_Dao;
import com.gamedashi.dtcq.floatview.manager.MyWindowManager;
import com.gamedashi.dtcq.floatview.model.db.Cards_evoitem;

/**
 * 进阶装备列表
 * 
 * @author longtaoger
 * 
 */
public class EquipListFloatView extends BaseFloatView implements
		OnClickListener, OnItemClickListener {
	private static EquipListFloatView mEquipListFloatViewIntance;

	private View mView;
	private ListView mListView;
	private GridView mGridView;
	private ImageView closeImageView;
	public List<Cards_evoitem> mcCards_evoitems;
	private List<List<Cards_evoitem>> mList;
	public Cards_Dao dao;

	private EquipListFloatView(Context context, String card_id) {
		super(context);
		mContext = context;

		initData(card_id);
		initView();
		finllData();
		setClick();

	}

	private void setClick() {

		mListView.setOnItemClickListener(this);

	}

	private void finllData() {

		if (mList.size() > 0) {
			EquipListAdapter mAdapter = new EquipListAdapter(mListView, mList);

			mListView.setAdapter(mAdapter);

		} else {
			Toast.makeText(MyFloatServes.mContext, "暂无数据", 1).show();
		}

	}

	public void initData(String card_id) {

		mList = new ArrayList<List<Cards_evoitem>>();
		mList.clear();
		dao = Cards_Dao.getInstance();

		String[] evoiteArray = { "蓝色+2", "紫色", "紫色+1", "紫色+2", "紫色+3", "紫色+4",
				"橙色" };

		for (int i = 0; i < evoiteArray.length; i++) {
			mcCards_evoitems = new ArrayList<Cards_evoitem>();

			mcCards_evoitems = dao.find_EvoitembyCardidandEvostr(card_id,
					evoiteArray[i]);
			if (mcCards_evoitems.size() > 0) {

				mList.add(mcCards_evoitems);

			}

		}

	}

	public static EquipListFloatView getInstance(String cardid) {

		if (mEquipListFloatViewIntance == null) {

			synchronized (EquipListFloatView.class) {

				if (mEquipListFloatViewIntance == null) {

					mEquipListFloatViewIntance = new EquipListFloatView(
							MyFloatServes.mContext, cardid);

				}

			}

		} else {
			// TODO
			mEquipListFloatViewIntance.initData(cardid);
			mEquipListFloatViewIntance.finllData();

		}

		return mEquipListFloatViewIntance;

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
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_equip_list_float_window, null);
		mListView = (ListView) mView
				.findViewById(R.id.tz_dtcq_equip_list_float_window_listview);
		closeImageView = (ImageView) mView
				.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_close);
		closeImageView.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		//
		if (v.getId() == R.id.tz_dtcq_equip_list_float_window_listview_close) {

			if (mView!= null) {

				MyWindowManager.getInstance(MyFloatServes.mContext).removeView(
						MyWindowManager.mEquipListFloatView);

			}

			/*
			 * // TODO 移除 FlaotMain.myWindowManager
			 * .removeView(MyWindowManager.mEquipListFloatView);
			 */

		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		// TODO
		Toast.makeText(mContext, "装备ID" + position, 0).show();

	}

}
