package com.example.cj_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class StartLogo extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startlogo_mein);
		sleep(1000);
		Intent intent = new Intent(StartLogo.this, LoginActivity.class);
		// 次画面のアクティビティ起動
		startActivity(intent);

	}

	public synchronized void sleep(long msec){
		try{
			wait(msec);
		}catch(InterruptedException e){

		}
	}
}


