package com.gamedashi.dtcq.floatview.manager;

import com.gamedashi.dtcq.floatview.utils.MyTools;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

public class BaseWindowManager {

	protected static Context mContext;
	protected static int ScreenWidth = 0;
	protected static int ScreenHeight = 0;
	protected static WindowManager mWindowManager;
	protected static WindowManager.LayoutParams mLayoutParams;

	protected static WindowManager.LayoutParams mLayoutParams_GameSpeed;
	protected static WindowManager.LayoutParams mLayoutParams_GameSpeed_one;
	protected static WindowManager.LayoutParams mLayoutParams_Exit;
	protected static WindowManager.LayoutParams mLayoutParams_Set;
	protected static WindowManager.LayoutParams mLayoutParams_RecruitDialog;
	protected static WindowManager.LayoutParams mLayoutParams_SetDialog;
	protected static WindowManager.LayoutParams mLayoutParams_Hero_Card;
	protected static WindowManager.LayoutParams mLayoutParams_Equip;
	protected static WindowManager.LayoutParams mLayoutParams_EquipList;
	protected static WindowManager.LayoutParams mLayoutParams_Dialog;
	protected static WindowManager.LayoutParams mLayoutParams_EquipmentList;
	protected static WindowManager.LayoutParams mLayoutParams_EquipmentList_Dialog;
	protected static WindowManager.LayoutParams mLayoutParams_Addition;
	protected static WindowManager.LayoutParams mLayoutParams_start_null;

	
	
	protected MyTools myTools;

	public static View mGamespeedFloatView;
	public static View mGamespeedFloatView_one;

	public static View mExitFloatView;
	public static View mSetFloatView;
	public static View mRecruitDialogFloatView;

	public static View mSetDialogFloatView;
	public static View mHero_Card_FloatView;
	public static View mEquipFloatView;
	public static View mEquipListFloatView;

	public static View mDialogFloatView;
	public static View mEquipmentListFloatView;
	public static View mEquipmentList_DialogFloatView;
	public static View mAdditionFloatView;

	public static View mStartFloatView_null;


	
}
