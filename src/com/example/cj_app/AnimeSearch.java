package com.example.cj_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

public class AnimeSearch extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animesearch_main);

		ImageButton Sbt = (ImageButton)findViewById(R.id.AniSearchBT);

		Sbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// インテントのインスタンス生成
				Intent intent = new Intent(AnimeSearch.this, AnimeSearchResult.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				}
		});


	}
}
