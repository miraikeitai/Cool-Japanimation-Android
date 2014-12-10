package com.example.cj_app;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_main);
		setTitle("アカウント画面");
		//setContentView(R.layout.sub);


		Button button2 = (Button)findViewById(R.id.button2);
		Button button1 = (Button)findViewById(R.id.button1);

		final EditText name = (EditText) findViewById(R.id.editText1);
		final EditText pass = (EditText) findViewById(R.id.editText2);

		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Sub 画面を起動
				Intent intent = new Intent(LoginActivity.this,
						MakeAccountActivity.class);
				startActivity(intent);
			}
		});

		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Sub 画面を起動

				JSONObject json = new JSONObject();
				try {
					json.accumulate("name",name.getText());
					json.accumulate("pass",pass.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// サーバ通信

				new LoginAsyncTask(LoginActivity.this).execute(json.toString());

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_account_main, container,
					false);
			return rootView;
		}
	}

}
