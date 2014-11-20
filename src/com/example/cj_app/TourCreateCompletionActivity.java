package com.example.cj_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

public class TourCreateCompletionActivity extends ActionBarActivity implements OnClickListener {

	String LOCAL_FILE = "log.txt";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourcreate_completion);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        View button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        View button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        sampleFileInput();

	}

    //ボタンを押した時の処理
    public void onClick(View v){
    	int id = v.getId();
		if (id == R.id.button1) {
			this.finish(); //CompletionActivityの終了
		} else if (id == R.id.button2) {
			deleteFile(LOCAL_FILE);
		}
    }

    private void sampleFileInput(){

        InputStream in;
        String lineBuffer;

        try {
            in = openFileInput(LOCAL_FILE); //LOCAL_FILE = "log.txt";

            BufferedReader reader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
            TextView txt1 = (TextView) findViewById(R.id.textView2);

            while( (lineBuffer = reader.readLine()) != null ){
                txt1.append(lineBuffer);
                txt1.append("\n");
            }
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
