package com.gamedashi.dtcq.floatview.ui.button;


import com.gamedashi.dtcq.floatview.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



/**
 * 滑动按钮
 * @author Administrator
 *
 */
public class SlideButton extends View {

	private Bitmap switchBG;	// 滑动开关的背景
	private Bitmap slideButtonBG; // 滑动块的背景
	private boolean currentState = false;	// 开关当前的状态, 默认为 关闭
	private int currentX;	// x轴的偏移量
	private boolean isSliding = false;		// 是否正在滑动
	private OnToggleStateChangedListener mListener;

	public SlideButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		initBitmap();
	}

	/**
	 * 当测量当前控件的宽高时回�?
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		// 设置�?关的宽和�?
		setMeasuredDimension(switchBG.getWidth(), switchBG.getHeight());
	}

	/**
	 * 绘制当前控件的方�?
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		
		// 1. 把滑动开关的背景画到画布�?
		canvas.drawBitmap(switchBG, 0, 0, null);		// 把背景平铺到控件�?
		
		// 2. 绘制滑动块显示的位置, �?或�?�关
		
		if(isSliding) {
			int left = currentX - (slideButtonBG.getWidth() / 2);
			if(left < 0) {
				left = 0;
			} else if(left > switchBG.getWidth() - slideButtonBG.getWidth()) {
				left = switchBG.getWidth() - slideButtonBG.getWidth();
			}
			
			canvas.drawBitmap(slideButtonBG, left, 0, null);
		} else {
			if(currentState) {	// 绘制�?关为�?的状�?
				canvas.drawBitmap(slideButtonBG, switchBG.getWidth() - slideButtonBG.getWidth(), 0, null);
			} else {	// 绘制�?关为关的状�??
				canvas.drawBitmap(slideButtonBG, 0, 0, null);
			}
		}
		super.onDraw(canvas);
	}

	/**
	 * 当产生触摸时间时回调此方�?
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: // 按下
			currentX = (int) event.getX();
			isSliding  = true;
			break;
		case MotionEvent.ACTION_MOVE: // 移动
			currentX = (int) event.getX();
			break;
		case MotionEvent.ACTION_UP: // 抬起
			isSliding = false;
			
			// 判断当前滑动�?, 偏向于哪�?�?, 如果滑动块的中心点小于背景的中心�?, 设置为关闭状�?
			
			int bgCenter = switchBG.getWidth() / 2;
			
			boolean state = currentX > bgCenter;		// 改变后的状�??
			
			// 调用用户的监听事�?
			if(state != currentState && mListener != null) {
				mListener.onToggleStateChanged(state);
			}

			currentState = state;
			break;
		default:
			break;
		}

		invalidate();		// 刷新当前控件, 会引起onDraw方法的调�?
		return true;
	}

	/**
	 * 初始化图�?
	 */
	private void initBitmap() {
		slideButtonBG = BitmapFactory.decodeResource(getResources(), R.drawable.tz_dtcq_float_gamespeed_bg_float_button_select);
		switchBG = BitmapFactory.decodeResource(getResources(), R.drawable.tz_dtcq_float_gamespeed_bg_float_button_bg);
	}  

	/**
	 * 设置�?关的状�??
	 * @param b
	 */
	public void setToggleState(boolean b) {
		currentState = b;
	}

	
	
	
	
	/**
	 * 获取�?关的状�??
	 * @return
	 */
	public boolean isCurrentState() {
		return currentState;
	}

	public void setCurrentState(boolean currentState) {
		this.currentState = currentState;
	}

	/**
	 * 设置�?关状态改变的监听事件
	 * @param listener
	 */
	public void setOnToggleStateChangedListener(OnToggleStateChangedListener listener) {
		this.mListener = listener;
	}
}
