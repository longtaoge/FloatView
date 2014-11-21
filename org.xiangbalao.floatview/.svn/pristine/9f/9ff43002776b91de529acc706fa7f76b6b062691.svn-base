package com.gamedashi.dtcq.floatview.dao;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gamedashi.dtcq.floatview.model.db.Cards;
import com.gamedashi.dtcq.floatview.model.db.Item;
import com.gamedashi.dtcq.floatview.model.db.Pass;

/**
 * 进阶装备列表
 * 
 * @author longtaoge
 * 
 */
public class Equipmen_Dao {

	public static List<Cards> myCards;

	private static Item myItems;
	private static final String path = "/data/data/com.example.mytest/files/cards.sqlite"; 
	//private static final String path = "/data/data/com.gamedashi.dtcq.daota/files/cards.sqlite";
			//"/data/data/com.gamedashi.dtcq.floatview1/files/cards.sqlite";
	
	//private static final String path = "/data/data/com.gamedashi.dtcq.daota.flaoatview/files/cards.sqlite";

	private static Equipmen_Dao instance;

	private Equipmen_Dao() {
	}

	// 排序 order by color desc,id asc

	/**
	 * 单例
	 * 
	 * @return
	 */
	public static Equipmen_Dao getInstance() {
		if (instance == null) {
			instance = new Equipmen_Dao();
		}

		return instance;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Item> find_all_Item() {

		List<Item> all_item = new ArrayList<Item>();
		Item mItem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);

		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20

		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20

		Cursor cursor = db.rawQuery(
				"select * from item   order by color desc,id asc ", null);

		while (cursor.moveToNext()) {
			mItem = new Item();
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}

			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));

			mItem.setMinGrade(cursor.getString(cursor
					.getColumnIndex("minGrade")));

			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			all_item.add(mItem);
		}

		cursor.close();

		db.close();

		return all_item;

	}

	

	/**
	 * 查询指定 id的 装备
	 * 
	 * @return
	 */
	public Item find_Item_ByID(String id) {

		
		Item mItem = new Item();

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);

		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20
		Cursor cursor = db.rawQuery(
				"select * from item   where id=? order by color desc,id asc",
				new String[] { id});
		while (cursor.moveToNext()) {
		
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));

			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}

			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));
			mItem.setMinGrade(cursor.getString(cursor
					.getColumnIndex("minGrade")));

			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			
		}

		cursor.close();

		db.close();

		return mItem;

	}

	
	
	
	
	
	/**
	 * 查询所有的 装备
	 * 
	 * @return
	 */
	public List<Item> find_All_Item_Bytype(String type) {

		List<Item> all_item = new ArrayList<Item>();
		Item mItem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);

		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20
		Cursor cursor = db.rawQuery(
				"select * from item   where type=? order by color desc,id asc",
				new String[] { type });
		while (cursor.moveToNext()) {
			mItem = new Item();
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));

			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}

			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));
			mItem.setMinGrade(cursor.getString(cursor
					.getColumnIndex("minGrade")));

			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			all_item.add(mItem);
		}

		cursor.close();

		db.close();

		return all_item;

	}

	/**
	 * 根据 颜色和类型 查询
	 * 
	 * @param color
	 * @param type
	 * @return
	 */
	public List<Item> find_by_ColorAndType(String color, String type) {

		List<Item> all_item = new ArrayList<Item>();
		Item mItem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);
		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20

		Cursor cursor = db
				.rawQuery(
						"select * from item where   color =? and type=? order by color desc,id asc",

						new String[] { color, type });

		while (cursor.moveToNext()) {
			mItem = new Item();
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}
			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));

			if (cursor.getString(cursor.getColumnIndex("minGrade")).length() > 0) {

				mItem.setMinGrade(cursor.getString(cursor.getColumnIndex("minGrade")));

			} else {
				mItem.setMinGrade("0");
			}

			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			all_item.add(mItem);
		}

		cursor.close();

		db.close();

		return all_item;

	}

	/**
	 * 根据颜色查询
	 * 
	 * @param color
	 * @return
	 */
	public List<Item> find_by_Color(String color) {

		List<Item> all_item = new ArrayList<Item>();
		Item mItem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);
		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20

		Cursor cursor = db.rawQuery(
				"select * from item where color=? order by color desc,id asc",

				new String[] { color });

		while (cursor.moveToNext()) {
			mItem = new Item();
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}
			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));
			mItem.setMinGrade(cursor.getString(cursor
					.getColumnIndex("minGrade")));

			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			all_item.add(mItem);
		}

		cursor.close();

		db.close();

		return all_item;

	}

	/**
	 * 根据合成品的ID查找 零件/合成材料
	 * 
	 * @param mainid
	 * @return
	 */
	public List<Item> findSubidByMainid(String mainid) {

		List<Item> all_item = new ArrayList<Item>();
		Item mItem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);
		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20

		Cursor cursor = db
				.rawQuery(
						"select * from item_compose inner join item where mainid=? and item.[id]=item_compose.[subid]",

						new String[] { mainid });

		while (cursor.moveToNext()) {
			mItem = new Item();
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}
			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));
			mItem.setMinGrade(cursor.getString(cursor
					.getColumnIndex("minGrade")));
			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			all_item.add(mItem);
		}

		cursor.close();

		db.close();

		return all_item;

	}

	/**
	 * 根据零件 查找 合成品
	 * 
	 * @param subid
	 * @return
	 */
	public List<Item> findMainidBySubid(String subid) {

		List<Item> all_item = new ArrayList<Item>();
		Item mItem;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);
		// select * from item where type=1 and color=4 order by color desc,id
		// asc limit 0,20

		Cursor cursor = db
				.rawQuery(
						"select * from item_compose inner join item where subid=? and item.[id]=item_compose.[mainid]",

						new String[] { subid });

		while (cursor.moveToNext()) {
			mItem = new Item();
			mItem.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));
			mItem.setName(cursor.getString(cursor.getColumnIndex("name")));
			mItem.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
			if (cursor.getString(cursor.getColumnIndex("description")) != null) {
				mItem.setDescription(cursor.getString(cursor
						.getColumnIndex("description")));
			}
			mItem.setEffect(cursor.getString(cursor.getColumnIndex("effect")));

			mItem.setPrice(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("price"))));
			mItem.setType(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("type"))));
			mItem.setColor(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("color"))));
			mItem.setMinGrade(cursor.getString(cursor
					.getColumnIndex("minGrade")));
			if (cursor.getString(cursor.getColumnIndex("enchant")) != null) {
				mItem.setEnchant(cursor.getString(cursor
						.getColumnIndex("enchant")));
			}

			all_item.add(mItem);
		}

		cursor.close();

		db.close();

		return all_item;

	}

	/**
	 * 根据装备查找英雄
	 * 
	 * @param item
	 * @return
	 */
	public List<Cards> findCardsByItem(String item) {

		myCards = new ArrayList<Cards>();
		Cards mCard;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READWRITE);

		Cursor cursor = db
				.rawQuery(
						"select * from cards_evoitem inner join cards on item_id=?and cards.[id]=cards_evoitem.[card_id]",
						new String[] { item });

		while (cursor.moveToNext()) {

			mCard = new Cards();
			mCard.setId(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("id"))));

			mCard.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
			mCard.setMyClass(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("Class"))));
			mCard.setDescription(cursor.getString(cursor
					.getColumnIndex("Description")));
			mCard.setPinyin(cursor.getString(cursor.getColumnIndex("pinyin")));
			mCard.setIcon(cursor.getString(cursor.getColumnIndex("Icon")));
			mCard.setCover(cursor.getString(cursor.getColumnIndex("Cover")));
			mCard.setPlace(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("place"))));
			mCard.setSkill1(cursor.getString(cursor.getColumnIndex("skill1")));
			mCard.setSkill2(cursor.getString(cursor.getColumnIndex("skill2")));
			mCard.setSkill3(cursor.getString(cursor.getColumnIndex("skill3")));
			mCard.setSkill3(cursor.getString(cursor.getColumnIndex("skill4")));
			mCard.setSkill1_des(cursor.getString(cursor
					.getColumnIndex("skill1_des")));
			mCard.setSkill2_des(cursor.getString(cursor
					.getColumnIndex("skill2_des")));
			mCard.setSkill3_des(cursor.getString(cursor
					.getColumnIndex("skill3_des")));
			mCard.setSkill4_des(cursor.getString(cursor
					.getColumnIndex("skill4_des")));
			mCard.setSkill1_icon(cursor.getString(cursor
					.getColumnIndex("skill1_icon")));
			mCard.setSkill2_icon(cursor.getString(cursor
					.getColumnIndex("skill2_icon")));
			mCard.setSkill3_icon(cursor.getString(cursor
					.getColumnIndex("skill3_icon")));
			mCard.setSkill4_icon(cursor.getString(cursor
					.getColumnIndex("skill4_icon")));
			mCard.setStrValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("StrValue"))));
			mCard.setIntValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("IntValue"))));
			mCard.setDexValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("DexValue"))));
			mCard.setMagValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("maxHealth"))));
			mCard.setAtnValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("AtnValue"))));
			mCard.setMagValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("MagValue"))));
			mCard.setAcValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("AcValue"))));
			mCard.setMrValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("MrValue"))));
			mCard.setCrtValue(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("CrtValue"))));

			mCard.setSource(cursor.getString(cursor.getColumnIndex("Source")));
			mCard.setSourceUrl(cursor.getString(cursor
					.getColumnIndex("SourceUrl")));
			mCard.setCover2(cursor.getString(cursor.getColumnIndex("Cover2")));
			mCard.setSkill1_rec(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("skill1_rec"))));
			mCard.setSkill2_rec(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("skill2_rec"))));
			mCard.setSkill3_rec(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("skill3_rec"))));
			mCard.setSkill4_rec(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("skill4_rec"))));
			mCard.setSkill1_recstr(cursor.getString(cursor
					.getColumnIndex("skill1_recstr")));
			mCard.setSkill2_recstr(cursor.getString(cursor
					.getColumnIndex("skill1_recstr")));
			mCard.setSkill3_recstr(cursor.getString(cursor
					.getColumnIndex("skill1_recstr")));
			mCard.setSkill4_recstr(cursor.getString(cursor
					.getColumnIndex("skill4_recstr")));
			mCard.setMinStar(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("minStar"))));
			mCard.setRecStar(Integer.valueOf(cursor.getString(cursor
					.getColumnIndex("recStar"))));

			mCard.setEvostr(cursor.getString(cursor.getColumnIndex("evostr")));

			myCards.add(mCard);

		}

		cursor.close();

		db.close();

		return myCards;

	}

	/**
	 * 根据装备ID 查 获取途径
	 * 
	 * @param item
	 * @return
	 */
	public List<Pass> findPassByItem(String item) {

		List<Pass> mPasses = new ArrayList<Pass>();

		Pass mPass;

		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,

		SQLiteDatabase.OPEN_READONLY);

		Cursor cursor = db
				.rawQuery(
						"select * from pass_item inner join pass on item_id=? and pass.[id]=pass_item.[pass_id]",
						new String[] { item });

		while (cursor.moveToNext()) {
			mPass = new Pass();

			mPass.setName(cursor.getString(cursor.getColumnIndex("name")));
			mPasses.add(mPass);

		}

		cursor.close();

		db.close();

		return mPasses;

	}

}
