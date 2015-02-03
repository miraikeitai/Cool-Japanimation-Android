package com.example.cj_app;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

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
		
		// リソースに準備した画像ファイルからBitmapを作成しておく
        Bitmap naruto, singeki, dragon;
        naruto = BitmapFactory.decodeResource(getResources(), R.drawable.naruto_title);
        singeki = BitmapFactory.decodeResource(getResources(), R.drawable.naruto_title);
        dragon = BitmapFactory.decodeResource(getResources(), R.drawable.naruto_title);
 
        // データの作成
        List<CustomData> objects = new ArrayList<CustomData>();
        CustomData item1 = new CustomData();
        item1.setImagaData(naruto);
        
        CustomData item2 = new CustomData();
        item2.setImagaData(singeki);
        //item2.setTextData("The second");
 
        CustomData item3 = new CustomData();
        item3.setImagaData(dragon);
        //item3.setTextData("Il terzo");
        
        CustomData item4 = new CustomData();
        item4.setImagaData(dragon);
        
        CustomData item5 = new CustomData();
        item4.setImagaData(naruto);
        
        objects.add(item1);
        objects.add(item2);
        objects.add(item3);
        objects.add(item4);
        objects.add(item5);
 
        CustomAdapter customAdapater = new CustomAdapter(this, 0, objects);
 
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(customAdapater);
	}
}
