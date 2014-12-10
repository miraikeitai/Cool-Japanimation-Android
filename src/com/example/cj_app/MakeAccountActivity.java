/**
 * 
 */
package com.example.cj_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author b1012234
 * 
 */
public class MakeAccountActivity extends Activity {
	Activity thisActivity;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		thisActivity = this;
		
		setContentView(R.layout.activity_account_make);
		setTitle("アカウント作成画面");

		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				EditText et = (EditText) findViewById(R.id.editText1);
				EditText et2 = (EditText) findViewById(R.id.editText2);				
				EditText et3 = (EditText) findViewById(R.id.editText3);
				
				Log.d("equals",""+et2.getText().toString().equals(et3.getText().toString()));

				if(et2.getText().toString().equals(et3.getText().toString())) {
					// JSON形式に変換して...
					JSONObject json = new JSONObject();
					try {
						json.accumulate("name",et.getText());
						json.accumulate("pass",et2.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// サーバ通信
					new MakeAccountAsyncTask(thisActivity).execute(json.toString());
					
				} else {
					new AlertDialog.Builder(MakeAccountActivity.this)
					.setTitle("えらー")
					.setMessage("パスワードが一致しません")
					.setCancelable(true)
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// TODO 自動生成されたメソッド・スタブ
							Log.d("AlertDialog", "Positive which :" + which);
						}
					})
					.show();
				}
				
			}

		});

	}
}
