package com.gamedashi.dtcq.floatview.adapter;

import java.util.List;

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
import com.gamedashi.dtcq.floatview.dao.Cards_Dao;
import com.gamedashi.dtcq.floatview.model.db.Cards_evoitem;
import com.gamedashi.dtcq.floatview.model.db.Item;

/**
 * 进阶装备列表—内嵌GridView
 * @author longtaoger
 *
 */
public class MyGridAdapter extends MyBaseAdapter {

	Cards_Dao dao = Cards_Dao.getInstance();
	private GridView mGridView;
	private List<Cards_evoitem> mList;
	Item myItem = new Item();

	public MyGridAdapter(GridView mGridView, List<Cards_evoitem> list) {
		this.mGridView = mGridView;
		this.mList = list;

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
		View itemView;

		GridViewHolder holder;
		if (convertView == null) {
			itemView = View
					.inflate(
							MyFloatServes.mContext,
							R.layout.tz_dtcq_equip_list_float_window_listview_item_griditem,
							null);
			itemView.setLayoutParams(new GridView.LayoutParams(
					GridView.LayoutParams.WRAP_CONTENT,
					GridView.LayoutParams.WRAP_CONTENT));
			holder = new GridViewHolder(itemView);

			itemView.setTag(holder);
			convertView = itemView;

		} else {
			holder = (GridViewHolder) convertView.getTag();

		}
		String item_id = String.valueOf(mList.get(position).getItem_id());

		// String.valueOf(Integer.valueOf(mList.get(position)
		// .getItem_id()));

		myItem = dao.findItems(item_id);

		// holder.icon.setBackgroundDrawable(MyApplication.mContext.getResources()
		// .getDrawable(R.drawable.tz_dtcq_float_window_close1));

		imageLoader.displayImage(myItem.getIcon(), holder.icon, options);

		// TODO 设置监听事件
		holder.icon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MyFloatServes.mContext, myItem.getName(), 0)
						.show();

			}
		});

		// Log.i("mlist", myItem.getIcon());

		holder.mItemName.setText(myItem.getName());
		return convertView;

	}

	public class GridViewHolder {

		private ImageView icon;
		private TextView mItemName;

		public GridViewHolder(View itemView) {
			icon = (ImageView) itemView
					.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_item_grid_icon);
			LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) icon
					.getLayoutParams(); // 取控件textView当前的布�?参数
			linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT;// 控件的高强制设成20
			icon.setAdjustViewBounds(true);
			linearParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;// 控件的宽强制设成30

			icon.setLayoutParams(linearParams);
			mItemName = (TextView) itemView
					.findViewById(R.id.tz_dtcq_equip_list_float_window_listview_item_grid_itemname);
		}

	}

}
