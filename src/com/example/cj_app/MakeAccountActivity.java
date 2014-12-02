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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author b1012234
 *
 */
public class MakeAccountActivity extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_account_make);
	        setTitle("アカウント作成画面");
	        
	        
	        Button button3 = (Button)findViewById(R.id.button3);
	        button3.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                // Sub 画面を起動
	                Intent intent = new Intent();
	                intent.setClassName("jp.example.cj_account", "jp.example.cj_account.MakeProfileActivity");
	                startActivity(intent);
	                
	                EditText et = (EditText)findViewById(R.id.editText1);
	                EditText et2 = (EditText)findViewById(R.id.editText2);
		            String s = et.getText().toString();
		            String s2 = et2.getText().toString();
		            try{
		            OutputStream out = openFileOutput("a.txt",MODE_PRIVATE);
		            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
		            writer.append(s);
		            writer.close();
		            }catch(IOException e){
		            e.printStackTrace();
		            }
		            
		            try{
		            	InputStream in = openFileInput("a.txt");
		            	BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			            EditText et3 = (EditText)findViewById(R.id.Test);
		            	 while((s = reader.readLine())!= null){
		            	 et3.append(s + s2);
		            	 et3.append("\n");
		            	 reader.close();
		            	 }
		            	}catch(IOException e){
		            	 e.printStackTrace();
		            	}
	            }
		        	            
	        });
	           
	        }
}
