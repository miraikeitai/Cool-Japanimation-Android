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
import android.widget.TextView;

/**
 * @author b1012234
 *
 */
public class MyPageFixProfile extends Activity {


     
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mypage_fixprofile);
		//プロフィール名前

		Button mprfbt = (Button)findViewById(R.id.MypageReturnFixBT);
		Button psbt = (Button)findViewById(R.id.ProfileSaveBT);
		

		
		psbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MyPageFixProfile.this, MyPage.class);
				startActivity(intent);
				}
		});
		
		mprfbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(MyPageFixProfile.this, MyPage.class);
				// 次画面のアクティビティ起動
			startActivity(intent);
				finish();
				}
		});
		
	}

}
