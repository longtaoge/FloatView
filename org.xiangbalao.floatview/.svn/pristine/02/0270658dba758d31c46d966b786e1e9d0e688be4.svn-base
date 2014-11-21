package com.gamedashi.dtcq.floatview.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.model.db.Item;

/**
 * 装备图鉴listview1 Gridview
 * 
 * @author longtaoger
 * 
 */
public class E_G_Adapter1 extends MyBaseAdapter {

	private Context mContext;
	private List<Item> mList;

	public E_G_Adapter1(Context mContext, List<Item> mainid_list) {
		this.mContext = mContext;
		this.mList = mainid_list;

	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {

			View itemView = View
					.inflate(
							mContext,
							R.layout.tz_dtcq_equipment_list_dialog_box_float_window_listitem1_griditem,
							null);

			holder = new ViewHolder(itemView);

			itemView.setTag(holder);
			convertView = itemView;

		} else if (convertView instanceof LinearLayout) {
			holder = (ViewHolder) convertView.getTag();
		}

		imageLoader.displayImage(mList.get(position).getIcon(),
				holder.mImageView, options);

		return convertView;
	}

	public class ViewHolder {
		private ImageView mImageView;

		public ViewHolder(View itemView) {
			mImageView = (ImageView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_listitem1_griditem_imageView);
		}

	}

}
