package com.example.cj_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class Navigation extends ActionBarActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_main);

		Button Mbt = (Button)findViewById(R.id.Mapbt);

		Mbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(Navigation.this, NavigationMap.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});

	}
}

