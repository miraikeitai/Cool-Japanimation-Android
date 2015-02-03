package com.example.cj_app;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class AnimeSearch extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animesearch_main);

		ImageButton Sbt = (ImageButton)findViewById(R.id.AniSearchBT);
		// リソースに準備した画像ファイルからBitmapを作成しておく
        Bitmap naruto, singeki, dragon;
        naruto = BitmapFactory.decodeResource(getResources(), R.drawable.naruto_title);
        singeki = BitmapFactory.decodeResource(getResources(), R.drawable.naruto_title);
        dragon = BitmapFactory.decodeResource(getResources(), R.drawable.naruto_title);
 
        // データの作成
        List<AnimeData> objects = new ArrayList<AnimeData>();
        AnimeData item1 = new AnimeData();
        item1.setImagaData(naruto);
        
        AnimeData item2 = new AnimeData();
        item2.setImagaData(singeki);
        //item2.setTextData("The second");
 
        AnimeData item3 = new AnimeData();
        item3.setImagaData(dragon);
        //item3.setTextData("Il terzo");
        
        AnimeData item4 = new AnimeData();
        item4.setImagaData(dragon);
        
        AnimeData item5 = new AnimeData();
        item4.setImagaData(naruto);
        
        objects.add(item1);
        objects.add(item2);
        objects.add(item3);
        objects.add(item4);
        objects.add(item5);
        
		AnimeSearchAdapter customAdapater = new AnimeSearchAdapter(this, 0, objects);
		 
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(customAdapater);
        
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
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
				Intent intent = new Intent(AnimeSearch.this, AnimeSearchDetail.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
            }
        });
	}
}
