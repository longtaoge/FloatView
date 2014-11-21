package com.gamedashi.dtcq.floatview.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gamedashi.dtcq.floatview.R;
import com.gamedashi.dtcq.floatview.model.db.Cards;

public class E_G_Adapter4 extends MyBaseAdapter {

	private Context mContext;
	private List<Cards> card_icon_list;

	public E_G_Adapter4(Context mContext, List<Cards> card_icon_list) {
		this.mContext = mContext;
		this.card_icon_list = card_icon_list;

	}

	@Override
	public int getCount() {
		return card_icon_list.size();
	}

	@Override
	public Object getItem(int position) {
		return card_icon_list.get(position);
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
							R.layout.tz_dtcq_equipment_list_dialog_box_float_window_listitem4_griditem,
							null);

			holder = new ViewHolder(itemView);

			itemView.setTag(holder);
			convertView = itemView;

		} else if (convertView instanceof LinearLayout) {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(card_icon_list.get(position).getTitle());
		
		
		
		imageLoader.displayImage(card_icon_list.get(position).getIcon(), holder.mImageView,options);
		
		
		
	//	Log.i("card1", card_icon_list.get(position).getIcon().toString());
		
		

		
		return convertView;
	}

	public class ViewHolder {
		private TextView name;
		private ImageView mImageView;

		public ViewHolder(View itemView) {
			name = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_listitem4_griditem_name);
			mImageView = (ImageView) itemView
					.findViewById(R.id.tz_dtcq_equipment_list_dialog_box_float_window_listitem4_griditem_imageView1);

		}

	}
}
