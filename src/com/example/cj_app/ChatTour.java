package com.example.cj_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

public class ChatTour extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_tour);

		View button2 = findViewById(R.id.button2);
		button2.setOnClickListener(this);

		View button3 = findViewById(R.id.button3);
		button3.setOnClickListener(this);

	}
	public void onClick(View v) {
		WebView webView;
		switch (v.getId()) {
		case R.id.button2:
			Intent i = new Intent (this, ChatChat.class);
			startActivity(i);
			break;
		}
		switch (v.getId()) {
		case R.id.button3:
			Intent i = new Intent (this, ChatMemo.class);
			startActivity(i);
			break;
		}
	}
}