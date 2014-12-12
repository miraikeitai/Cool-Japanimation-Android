/**
 * 
 */
package com.example.cj_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author b1012234
 *
 */
public class MyPage extends Activity {
	TextView textView;
	TextView textView2;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mypage_main);
		
		//MyPageFixProfileからNameの呼び出して名前に書き込む

		textView = (TextView) findViewById(R.id.ProfName);
		

		
		textView.setText("ジョン");
		
		//MyPageFixProfileからcommentsの呼び出して名前に書き込む

		textView2 = (TextView) findViewById(R.id.Profcomments);
		textView2.setText("ナルトLOVE!!!!");
		
		
	
	Button fpbt = (Button)findViewById(R.id.FixProfileBT);
	Button mpbtbt = (Button)findViewById(R.id.MyPageBsckTopBT);
	Button trbt = (Button)findViewById(R.id.TourRequestBT);
	
	
	fpbt.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// インテントのインスタンス生成
			Intent intent = new Intent(MyPage.this, MyPageFixProfile.class);
			// 次画面のアクティビティ起動
			startActivity(intent);
			//finish();
			}
	});
	trbt.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// インテントのインスタンス生成
			Intent intent = new Intent(MyPage.this, MyPageRequest.class);
			// 次画面のアクティビティ起動
			startActivity(intent);
			//finish();
			}
	});
	mpbtbt.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// インテントのインスタンス生成
			Intent intent = new Intent(MyPage.this, TopPage.class);
			// 次画面のアクティビティ起動
			startActivity(intent);
			//finish();
			}
		
	});
	}


}
