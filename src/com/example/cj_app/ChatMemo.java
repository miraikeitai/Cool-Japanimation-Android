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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChatMemo extends Activity implements OnClickListener{

	EditText editText1;
	Button save,read,back;
	String fileName;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_memo);

		View button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
	}

	public void onClick(View v){
		switch (v.getId()) {
        case R.id.button5:
            Intent i = new Intent (this, ChatTour.class);
            startActivity(i);
            break;
        }
	}

	//保存ボタンをクリックした時の動作を定義する
	public void onClick_write(View view) {
		EditText edittext = (EditText)findViewById(R.id.editText1);
		String str = edittext.getText().toString();

		//try{}で返された例外クラスがcatch()の()の中にある例外クラスと一致した場合、
		//catch(){}の{}で書かれた命令を実行する仕組みになっています。
		//printStackTrace()メソッドは標準出力エラーへ送り出され、LogCatに報告されます。
		try{
			//memo.txtファイルを開き,OutputStream型の変数outputstreamへ入れる。ファイルがない場合は勝手に作ってくれます
			OutputStream outputstream = openFileOutput("memo.txt",MODE_PRIVATE);
			//PrintWriter型の変数writerを用意して、書き込みオブジェクトを生成しています
			PrintWriter writer =new PrintWriter(new OutputStreamWriter(outputstream,"UTF-8"));
			//ファイルにstrの値を追加で書きます
			writer.append(str);
			//ファイルを閉じます。
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		Toast.makeText(this, "保存しました", Toast.LENGTH_SHORT).show();
	}

	//読み込みボタンをクリックした時の動作を定義する
	public void onClick_read(View view) {
		try{
			String str;
			//memo.txtファイルを開き,InputStream型の変数inputstreamへ入れる。
			InputStream inputstream = openFileInput("memo.txt");
			//BufferedReader型の変数readerを用意し、読み込みオブジェクトを生成しています
			BufferedReader reader =new BufferedReader(new InputStreamReader(inputstream,"UTF-8"));
			TextView edittext = (TextView)findViewById(R.id.textView1);
			//テキストビューの表示を空白にする。
			edittext.setText("");
			/*
			 * while()｛｝は繰り返し処理を行う記述です。
			 * ()の中が真である間、{}の中の処理を行うという意味になります。
			 * readLine()メソッドは一行ずつ読み込む動作です。
			 * readLine()メソッドが何も無い行を読み込んだとき、nullを返すことになっています。
			 * 次の記述は、strの中身がnullになる間、strを追加書きし、加えて改行を行う。
			 */
			while((str = reader.readLine())!= null){
				edittext.append(str);
				edittext.append("\n");
			}
			//ファイルを閉じます。
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		Toast.makeText(this, "読み込みました", Toast.LENGTH_SHORT).show();
	}

	//削除ボタンをクリックした時の動作を定義する
	public void onClick_delete(View view) {
		TextView textview = (TextView)findViewById(R.id.textView1);
		textview.setText("");
		//memo.txtファイルを削除します。
		deleteFile("memo.txt");
		textview.setText(R.string.text);
		Toast.makeText(this, "ローカルファイルを削除しました", Toast.LENGTH_SHORT).show();
	}

}