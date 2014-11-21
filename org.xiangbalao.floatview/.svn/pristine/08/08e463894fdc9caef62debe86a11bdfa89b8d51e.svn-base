package com.gamedashi.dtcq.floatview.view;

import java.net.URLDecoder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.PluginState;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.gamedashi.dtcq.floatview.MyFloatServes;
import com.gamedashi.dtcq.floatview.R;

/**
 * 招幕
 * 
 * @author longtaoger
 * 
 */
public class RecruitDialogFloatView extends BaseFloatView implements
		OnClickListener {
	private static RecruitDialogFloatView mDialogFloatViewIntance;
	private View mView;
	private WebView webView;

	private static ImageView close;

	private FrameLayout customViewContainer;
	private WebChromeClient.CustomViewCallback customViewCallback;

	private View mCustomView;
	private myWebViewClient mWebViewClient;
	private myWebChromeClient mWebChromeClient;

	private RecruitDialogFloatView(Context context) {
		super(context);
		mContext = context;
		// 初始化view
		initView();
		setClick();
	}

	private void setClick() {
		close.setOnClickListener(this);

	}

	// recruit
	public static RecruitDialogFloatView getInstance() {

		if (mDialogFloatViewIntance == null) {

			synchronized (RecruitDialogFloatView.class) {

				if (mDialogFloatViewIntance == null) {

					mDialogFloatViewIntance = new RecruitDialogFloatView(
							MyFloatServes.mContext);

				}

			}

		}

		return mDialogFloatViewIntance;

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

	private void loadWebview() {
		WebSettings settings = webView.getSettings();

		mWebViewClient = new myWebViewClient();
		webView.setWebViewClient(mWebViewClient);

		mWebChromeClient = new myWebChromeClient();
		webView.setWebChromeClient(mWebChromeClient);

		webView.setBackgroundColor(Color.parseColor("#000000"));

		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAppCacheEnabled(true);
		// webView.getSettings().setBuiltInZoomControls(true);

		webView.getSettings().setSaveFormData(true);
		settings.setPluginState(PluginState.ON);
		
		
		
		String path=MyFloatServes.mContext.getCacheDir()+"/daota/";
		settings.setAppCachePath(path);
		settings.setAppCacheEnabled(true);
		
		
		webView.getSettings().setSupportZoom(true);
		settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
		settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		
		Log.i("path1", path + "/path");
		webView.loadUrl("http://dtcq.gamedashi.com/news/dtcqplugin.html");

	}

	@Override
	public void initView() {
		mView = LayoutInflater.from(mContext).inflate(
				R.layout.tz_dtcq_gamespeed_float_window_recruit_dialog_box,
				null);

		webView = (WebView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_dialog_box_close_webView);

		loadWebview();

		close = (ImageView) mView
				.findViewById(R.id.tz_dtcq_gamespeed_float_window_dialog_box_close_imageView1);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tz_dtcq_gamespeed_float_window_dialog_box_close_imageView1) {

			if (mView.getParent() != null) {
				remove();
				mDialogFloatViewIntance = null;
			}

		}

	}

	/**
	 * 处理 视频全屏问题
	 * 
	 * @author longtaoge
	 * 
	 */
	class myWebChromeClient extends WebChromeClient {
		private Bitmap mDefaultVideoPoster;
		private View mVideoProgressView;

		@Override
		public void onShowCustomView(View view, int requestedOrientation,
				CustomViewCallback callback) {
			onShowCustomView(view, callback); // To change body of overridden
												// methods use File | Settings |
												// File Templates.
		}

		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {

			// if a view already exists then immediately terminate the new one
			if (mCustomView != null) {
				callback.onCustomViewHidden();
				return;
			}
			mCustomView = view;
			webView.setVisibility(View.GONE);
			customViewContainer.setVisibility(View.VISIBLE);
			customViewContainer.addView(view);
			customViewCallback = callback;
		}

		@Override
		public View getVideoLoadingProgressView() {

			if (mVideoProgressView == null) {
				LayoutInflater inflater = LayoutInflater
						.from(MyFloatServes.mContext);
				mVideoProgressView = inflater.inflate(
						R.layout.tz_dtcq_floatview_video_progress, null);
			}
			return mVideoProgressView;
		}

		@Override
		public void onHideCustomView() {
			super.onHideCustomView(); // To change body of overridden methods
										// use File | Settings | File Templates.
			if (mCustomView == null)
				return;

			webView.setVisibility(View.VISIBLE);
			customViewContainer.setVisibility(View.GONE);

			// Hide the custom view.
			mCustomView.setVisibility(View.GONE);

			// Remove the custom view from its container.
			customViewContainer.removeView(mCustomView);
			customViewCallback.onCustomViewHidden();

			mCustomView = null;
		}
	}

	class myWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// 如果是卡片id 跳到英雄详情_技能加点
			url = URLDecoder.decode(url);

			if (url.contains("card=")) {
				// Log.i("url1", url);
				//
				// url = StringUtils.substringBetween(url + "/", "card=", "/");
				//
				// Intent intent = new Intent();
				// intent.putExtra("id", url);
				// HeroDetailsMainActivity.id = url;
				// HeroDetailsMainActivity.index = 0;
				// url = WebviewActivity.this.url;
				// intent.setClass(WebviewActivity.this,
				// HeroDetailsMainActivity.class);
				// startActivity(intent);
				// webView.onPause();

				return true;
			} else {
				loadurl(view, url);
				return true;
			}

		}

		private void loadurl(WebView view, String url) {

			view.loadUrl(url);

		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// Log.e("onPageStarted", "");
			// showLoadingView();
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// 加载完成
			// Log.e("onPageFinished", "");
			// dismissLoadingView();
			super.onPageFinished(view, url);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// Toast.makeText(mContext, "加载失败，请检查网络", 0).show();
			super.onReceivedError(view, errorCode, description, failingUrl);
		}
	}

}
