package com.example.cj_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ChatChat extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	private final int FP = ViewGroup.LayoutParams.FILL_PARENT; 
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT; 
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        
        WebView webview = new WebView(this);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
       // settings.setPassword(false);
        settings.setSaveFormData(false);
        settings.setSupportZoom(false);
        
        webview.setWebViewClient(new WebViewClient(){
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url){
        		return false;
        	}
        	
        	@Override
        	public void onReceivedError(WebView view, int errorCode, String description,String url){
        		showDialog(ChatChat.this,"","通信エラーです");
        	}
        	
        });
        setContentView(webview);
        webview.loadUrl("http://cooljapanimation.dip.jp/chat/chat1/main.html");
    }
    private void showDialog(Context context, String title, String text){
    	AlertDialog.Builder ad = new AlertDialog.Builder(context);
    	ad.setTitle(title);
    	ad.setMessage(text);
    	ad.setPositiveButton("OK", null);
    	ad.show();
    }
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.button4:
            Intent i = new Intent (this, ChatTour.class);
            startActivity(i);
            break;
        }
    }
}
