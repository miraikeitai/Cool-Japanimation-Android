package com.example.cj_app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Build;

public class TourCreateConfirmationActivity extends ActionBarActivity implements OnClickListener{
	
	//public static CheckFinish mflag;
	
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
        
      //  mflag = new CheckFinish();
    }

  //ボタンを押した時の処理
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.button1://Back
    		this.finish(); //ConfirmationActivityの終了
    		break;
    	case R.id.button2://OK(画面遷移)
    		
    		Intent i = new Intent(this, TourCreateCompletionActivity.class);
    		startActivity(i);
    		this.finish();
    		TourCreatingActivity.mflag.setFlagState(true);//CreatingActivityが終了処理に入る
    		break;
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
            View rootView = inflater.inflate(R.layout.fragment_toursearch_main, container, false);
            return rootView;
        }
    }

}
