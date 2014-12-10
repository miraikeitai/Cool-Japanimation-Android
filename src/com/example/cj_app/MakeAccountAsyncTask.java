package com.example.cj_app;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class MakeAccountAsyncTask extends AsyncTask<String, Integer, String>{

	Activity activity;

	public MakeAccountAsyncTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected String doInBackground(String... contents) {
		// TODO Auto-generated method stub
		String response = null;
		int statusCode = 0;
        ArrayList <NameValuePair> params = new ArrayList <NameValuePair>();
        params.add( new BasicNameValuePair("login", contents[0]));

		// 送信先URLを指定して通信を確立
		String url="http://rhyth.dip.jp/213create_account.php";
		HttpPost httpPost = new HttpPost(url);

		// パラメータの設定
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			Log.d("httPostQuery", params.toString());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse httpResponse = null;

		try {
			httpResponse = client.execute(httpPost);

			// ステータスコードを取得
			statusCode = httpResponse.getStatusLine().getStatusCode();

			// レスポンスを取得
			HttpEntity entity = httpResponse.getEntity();
			response = EntityUtils.toString(entity);

			// リソースを解放
			entity.consumeContent();

			// クライアントを終了させる
			client.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("RESPONSE", "["+statusCode+"]　"+response);
		return response;
	}

	@Override
	protected void onPostExecute(String result) {
		Log.d("LOG", "EXECUTED onPostExecute");

		Intent intent = new Intent(activity,
				TopPage.class);
		activity.startActivityForResult(intent, 0);
	}
}
