package com.example.cj_app;


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
import android.widget.EditText;

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
    	int id = v.getId();
		if (id == R.id.button1) {
			Intent i = new Intent(this, TourSearchMain.class);
			startActivity(i);
		} else if (id == R.id.button2) {
		}
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
