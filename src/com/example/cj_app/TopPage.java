package com.example.cj_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class TopPage extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_page);
		
		ImageButton asbt = (ImageButton)findViewById(R.id.AniSearchBT);
		ImageButton tsbt = (ImageButton)findViewById(R.id.TourSearchBT);
		ImageButton tcbt = (ImageButton)findViewById(R.id.TourCreateBT);
		
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
				Intent intent = new Intent(TopPage.this, TourCreatemain.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
