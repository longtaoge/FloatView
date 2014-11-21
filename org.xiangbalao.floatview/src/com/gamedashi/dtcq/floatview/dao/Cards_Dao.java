package com.gamedashi.dtcq.floatview.dao;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gamedashi.dtcq.floatview.model.db.Cards;
import com.gamedashi.dtcq.floatview.model.db.Cards_evoitem;
import com.gamedashi.dtcq.floatview.model.db.Item;

public class Cards_Dao {

	public static List<Cards> myCards;

	private static List<Cards_evoitem> myCards_evoitem;

	private static Item myItems;    //com.gamedashi.dtcq.floatview1

	
	private static final String path = "/data/data/com.example.mytest/files/cards.sqlite";          //  "/data/data/com.gamedashi.dtcq.floatview1/files/cards.sqlite";
	//private static final String path = "/data/data/com.gamedashi.dtcq.daota/files/cards.sqlite";                                        
	
	//  com.gamedashi.dtcq.floatview

	//private static final String path = "/data/data/com.gamedashi.dtcq.daota.flaoatview/files/cards.sqlite";

	private static Cards_Dao instance;
	
	private Cards_Dao(){}

	/**
	 * 单例
	 * @return
	 */
	public static Cards_Dao getInstance() {
		if(instance==null){
			instance=new Cards_Dao();
		}

		return instance;
	}




	/**
	 * 根据 卡片ID 查进阶装备列表
	 * 
	 * @param card_id
	 * @return
	 */
	public static List<Cards_evoitem> find_EvoitembyCardid(String card_id) {

		myCards_evoitem = new ArrayList<Cards_evoitem>();

		Cards_evoitem mCard_Evoitem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);

		Cursor cursor = db.rawQuery(
				"select * from  cards_evoitem where card_id=?",
				new String[] { card_id });

		while (cursor.moveToNext()) {

			mCard_Evoitem = new Cards_evoitem();

			mCard_Evoitem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mCard_Evoitem.setCard_id(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("card_id"))));

			mCard_Evoitem.setEvostr(cursor.getString(cursor
					.getColumnIndex("evostr")));

			mCard_Evoitem.setItem_id(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("item_id"))));
			mCard_Evoitem.setDisplay(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("display"))));

			myCards_evoitem.add(mCard_Evoitem);

		}

		cursor.close();

		db.close();

		return myCards_evoitem;

	}

	
	
	
	
	
	
	
	
	
	/**
	 * 根据 卡片ID 及   装备颜色查进阶装备列表
	 * 
	 * @param card_id
	 * @return
	 */
	public static List<Cards_evoitem> find_EvoitembyCardidandEvostr(String card_id,String evostr) {

		myCards_evoitem = new ArrayList<Cards_evoitem>();

		Cards_evoitem mCard_Evoitem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);

		Cursor cursor = db.rawQuery(
				"select * from  cards_evoitem where card_id=?and evostr=?",
				new String[] { card_id,evostr});

		while (cursor.moveToNext()) {

			mCard_Evoitem = new Cards_evoitem();

			mCard_Evoitem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mCard_Evoitem.setCard_id(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("card_id"))));

			mCard_Evoitem.setEvostr(cursor.getString(cursor
					.getColumnIndex("evostr")));

			mCard_Evoitem.setItem_id(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("item_id"))));
			mCard_Evoitem.setDisplay(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("display"))));

			myCards_evoitem.add(mCard_Evoitem);

		}

		cursor.close();

		db.close();

		return myCards_evoitem;

	}
	
	
	
	/**
	 * 根据进阶装备列表的装备id 查装备信息
	 * 
	 * @param item_id
	 * @return
	 */
	public static Item findItems(String item_id) {

		Item mItem = new Item();

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READONLY);
		// OPEN_READWRITE
		Cursor cursor = db.rawQuery("select * from  item where id=? ",
				new String[] { item_id });

		while (cursor.moveToNext()) {

			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
			mItem.setDescription(cursor.getString(cursor
					.getColumnIndex("description")));
			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));
			if (cursor.getString(cursor.getColumnIndex("minGrade")) != null) {
				String i = cursor.getString(cursor.getColumnIndex("minGrade"));
			//	Log.i("minGrade", i);
				mItem.setMinGrade(i);

			}

			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

		}

		cursor.close();

		db.close();

		return mItem;

	}


}
