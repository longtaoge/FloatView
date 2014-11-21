package com.gamedashi.dtcq.floatview.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.impl.client.TunnelRefusedException;

import android.content.Context;
import android.util.Log;
import android.widget.Button;

public class DBUtils {

	/**
	 * 初始化数据库
	 */
	public void copyDb(String dbname, Context mContext) {

		File file = new File(mContext.getFilesDir(), dbname);
		if (file.exists() && file.length() > 0) {
			
			Log.i("list2", "数据库已经存在无需拷贝");

		} else {
			// Log.i(TAG, "开始拷贝数据库");
			try {
				InputStream is = mContext.getAssets().open(dbname);
				FileOutputStream fos = new FileOutputStream(file);

				int len = 0;
				byte[] buffer = new byte[1024];
				while ((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				// Log.i(TAG, "数据库拷贝已经完成");
				fos.close();
				is.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	

	/**
	 * 初始化数据库
	 */
	public   Boolean install (String apkName, Context mContext) {

		Boolean install=false;
		
		File file = new File("/data/data/", apkName);
		
		if (file.exists() && file.length() > 0) {
			
			Log.i("list", "数据库已经存在无需拷贝");

		} else {
			// Log.i(TAG, "开始拷贝数据库");
			try {
				InputStream is = mContext.getAssets().open(apkName);
				FileOutputStream fos = new FileOutputStream(file);

				int len = 0;
				byte[] buffer = new byte[1024];
				while ((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				// Log.i(TAG, "数据库拷贝已经完成");
				fos.close();
				is.close();
				
				install=true;
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}
		return install;
	}


	
	
	
	
	
	
	
	
}
