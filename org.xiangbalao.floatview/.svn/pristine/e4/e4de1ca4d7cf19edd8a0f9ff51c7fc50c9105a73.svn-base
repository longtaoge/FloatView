package com.gamedashi.dtcq.floatview.adapter;

import java.util.List;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.model.db.Cards_evoitem;

public class EquipListAdapter extends MyBaseAdapter {
	private View mListvView;
	private List<List<Cards_evoitem>> mEvoitemist;

	public EquipListAdapter(ListView mListView, List<List<Cards_evoitem>> mList) {

		this.mListvView = mListvView;
		this.mEvoitemist = mList;
	}

	@Override
	public int getCount() {

		return mEvoitemist.size();
	}

	@Override
	public Object getItem(int position) {

		return mEvoitemist.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		MyGridAdapter gAdapter;
		EquipViewHolder holder=null ;
	
		
		if (convertView == null) {
			
			View itemView = View.inflate(MyFloatServes.mContext,
					R.layout.tz_dtcq_equip_list_float_window_listview_item,
					null);

			holder = new EquipViewHolder(itemView);

			itemView.setTag(holder);
			convertView = itemView;

		} else if (convertView instanceof LinearLayout) {
			holder = (EquipViewHolder) convertView.getTag();
		}

		String evoString = "";
		if (mEvoitemist.size() > 0) {
			List<Cards_evoitem> tmpEvoitems = mEvoitemist.get(position);
			if (tmpEvoitems.size() > 0) {
				evoString = tmpEvoitems.get(0).getEvostr();
			} else {
				Toast.makeText(MyFloatServes.mContext, "没有数据", 1).show();
			}

		}

		String evoColor = "#0E54AA";
		holder.evostr.setText(evoString);

		if (evoString.contains("蓝色")) {
			evoColor = "#0E54AA";

		} else if (evoString.contains("紫色")) {
			evoColor = "#D200FF";
		} else if (evoString.contains("橙色")) {
			evoColor = "#EF8800";
		}
		holder.evostr.setTextColor(Color.parseColor(evoColor));

		gAdapter = new MyGridAdapter(holder.mGridView, mEvoitemist.get(position));
		
	//	Log.i("mList"+position+"mEvoitemist.size"+mEvoitemist.size(), String.valueOf(position));
		holder.mGridView.setAdapter(gAdapter);
		// TODO 条目点击
		holder.mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MyFloatServes.mContext, "成功�?", 0).show();
				
			}
		});
		
		return convertView;
	}

	public class EquipViewHolder {

		private TextView evostr;
		private  GridView mGridView;

		public EquipViewHolder(View itemView) {
			evostr = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_item_evostr);
			mGridView = (GridView) itemView
					.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_item_grid);
		}
	}

}
