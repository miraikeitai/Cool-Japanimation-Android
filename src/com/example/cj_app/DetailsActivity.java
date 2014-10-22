package com.example.cj_app;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class DetailsActivity extends ActionBarActivity implements OnClickListener{
	EditText editText;
//	AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toursearch_details);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
    	/*
    	alertDialog.setTitle("Confirmation");
    	alertDialog.setMessage("message");
    	*/
        
        View button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        View button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);      
        
    }

  //ボタンを押した時の処理
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.button1:
    		Intent i = new Intent(this, TourSearchMain.class);
    		startActivity(i);
    		break;
    	case R.id.button2:
    //	alertDialog.show();
    		break;
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toursearch_main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_toursearch_main, container, false);
            return rootView;
        }
    }

}
