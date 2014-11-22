
package com.example.cj_app;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
import android.widget.TextView;

public class TourCreateConfirmationActivity extends ActionBarActivity implements OnClickListener{

	//public static CheckFinish mflag;

	String data1, data2, data3, data4, data5, data6;
	String LOCAL_FILE = "log.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourcreate_confirmation);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        View button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        View button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Intent intent = getIntent();
        data1 = intent.getStringExtra("data1");
        data2 = intent.getStringExtra("data2");
        data3 = intent.getStringExtra("data3");
        data4 = intent.getStringExtra("data4");
        data5 = intent.getStringExtra("data5");
        data6 = intent.getStringExtra("data6");

        TextView txt1 = (TextView) findViewById(R.id.textView8);
        txt1.setText(data1);
		TextView txt2 = (TextView) findViewById(R.id.textView9);
		txt2.setText(data2);
		TextView txt3 = (TextView) findViewById(R.id.textView10);
		txt3.setText(data3);
		TextView txt4 = (TextView) findViewById(R.id.textView11);
		txt4.setText(data4);
		TextView txt5 = (TextView) findViewById(R.id.textView12);
		txt5.setText(data5);
		TextView txt6 = (TextView) findViewById(R.id.textView13);
		txt6.setText(data6);

      //  mflag = new CheckFinish();
    }

  //ボタンを押した時の処理
    public void onClick(View v){
    	int id = v.getId();
		if (id == R.id.button1) {
			this.finish(); //ConfirmationActivityの終了
		} else if (id == R.id.button2) {
			sampleFileOutput();
			Intent i = new Intent(this, TourCreateCompletionActivity.class);
			startActivity(i);
			this.finish();
			TourCreatingActivity.mflag.setFlagState(true);//CreatingActivityが終了処理に入る
		}
    }

    /*外部ファイルへ保存*/
    private void sampleFileOutput(){

        OutputStream out;
        try {
            out = openFileOutput(LOCAL_FILE, MODE_PRIVATE|MODE_APPEND);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));

            //追記する
            writer.append("Title " + data1 + "\n");
            writer.append("Date " + data2 + " ~ " + data3 + "\n");
            writer.append("Place " + data4 + "\n");
            writer.append("Application deadline " + data5 + "\n");
            writer.append("Recomended point " + data6 + "\n");
            writer.append("\n");
            writer.close();

        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tourcreate_main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_tourcreate_main, container, false);
            return rootView;
        }
    }

}

