package com.example.cj_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Navigation extends ActionBarActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_main);

		Button Mbt = (Button)findViewById(R.id.Mapbt);
		final EditText place = (EditText)findViewById(R.id.Place);

		Mbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//入力した情報を取得
				if(place != null){
					String pl_text = place.getText().toString();
					if(pl_text.equals("")){

					}else{
						// インテントのインスタンス生成
						Intent intent = new Intent(Navigation.this, NavigationMap.class);
						//次のインテントに値を投げる
						Bundle bandle = new Bundle();
						bandle.putString("place", pl_text);
						intent.putExtras(bandle);
						// 次画面のアクティビティ起動
						startActivity(intent);
					}
				}

			}
		});

	}
}

