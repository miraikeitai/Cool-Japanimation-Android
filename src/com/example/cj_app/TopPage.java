package com.example.cj_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TopPage extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_page);

		ImageButton asbt = (ImageButton)findViewById(R.id.AniSearchBT);
		ImageButton tsbt = (ImageButton)findViewById(R.id.TourSearchBT);
		ImageButton tcbt = (ImageButton)findViewById(R.id.TourCreateBT);
		Button nvbt = (Button)findViewById(R.id.NaviBT);
		Button mpbt = (Button)findViewById(R.id.MyPageBT);

		asbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(TopPage.this, AnimeSearch.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});

		tsbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(TopPage.this, TourSearchMain.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});

		tcbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(TopPage.this, TourCreatingActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});

		nvbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(TopPage.this, ChatTour.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});
		
		mpbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(TopPage.this, MyPage.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
			finish();
				}
		});
	
	}
}

	
