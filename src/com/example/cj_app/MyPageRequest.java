/**
 * 
 */
package com.example.cj_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author b1012234
 *
 */
public class MyPageRequest extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_mypage_request);
	
	Button rbmpbt = (Button)findViewById(R.id.RequestBackMyPageBT);
	
	rbmpbt.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// インテントのインスタンス生成
			Intent intent = new Intent(MyPageRequest.this, MyPage.class);
			// 次画面のアクティビティ起動
			startActivity(intent);
			}
	});
	}
}
