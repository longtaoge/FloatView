package com.gamedashi.dtcq.floatview.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.model.db.Item;
import com.gamedashi.dtcq.floatview.view.EquipmentListFloatView;

/**
 * 装备图鉴 、装备列表__GridView
 * 
 * @author longtaoger
 * 
 */
public class EquipmentGridAdapter extends MyBaseAdapter {

	private Context mContext;
	private List<Item> mItems;
	private GridView mGridView;

	public EquipmentGridAdapter(Context mContext, List<Item> mItems) {
		this.mContext = mContext;
		this.mItems = mItems;
		// this.mGridView = mGridView;

	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		EquipmentViewHolder holder = null;

		if (convertView == null) {

			View itemView = View.inflate(MyFloatServes.mContext,
					R.layout.tz_dtcq_equipment_list_float_window_gridview_item,
					null);

			holder = new EquipmentViewHolder(itemView);

			itemView.setTag(holder);
			convertView = itemView;

		} else if (convertView instanceof LinearLayout) {

			holder = (EquipmentViewHolder) convertView.getTag();
		}

		imageLoader.displayImage(mItems.get(position).getIcon(), holder.icon,
				options);

		holder.effect.setText(mItems.get(position).getName());

		holder.icon.setOnClickListener(new OnClickListener() {
			// TODO 设置点击事件 处理事件分发
			@Override
			public void onClick(View v) {
				openEquipmentList_Dialog(mItems.get(position).getId());
				// Toast.makeText(MyApplication.mContext,
				// "" + mItems.get(position).getId(), 0).show();

			}

		});

		return convertView;

	}

	public class EquipmentViewHolder {

		private ImageView icon;
		private TextView effect;

		public EquipmentViewHolder(View itemView) {
			icon = (ImageView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_float_window_gridview_item_icon);
			effect = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_float_window_gridview_item_name);

		}

	}

	/**
	 * �?启装备对话框
	 * 
	 * @param mItemId
	 */
	private void openEquipmentList_Dialog(int mItemId) {

		mMyWindowManager.andEquipmentList_DialogFloatView(String
				.valueOf(mItemId));
		mMyWindowManager.removeView(EquipmentListFloatView.getInstance()
				.getFloatView());
	}
}
