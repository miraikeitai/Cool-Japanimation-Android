package com.example.cj_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class ChatTop extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);

        View button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.button1:
            Intent i = new Intent (this, ChatTour.class);
            startActivity(i);
            break;
        }
    }
}