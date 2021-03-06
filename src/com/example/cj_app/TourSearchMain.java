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
import android.widget.TextView;

public class TourSearchMain extends ActionBarActivity implements OnClickListener{
	EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toursearch_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        View button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        editText = (EditText)findViewById(R.id.editText1);



    }

  //ボタンを押した時の処理
    public void onClick(View v){
    	int id = v.getId();
		if (id == R.id.button1) {
			String str = editText.getText().toString();
			if(CheckData(str)){//dataBaseにdataがあった場合

    			//リストに変更する必要ありか
    			TextView txtTime1 = (TextView) findViewById(R.id.textView3);
    			txtTime1.setText("test1");
    			TextView txtTime2 = (TextView) findViewById(R.id.textView4);
    			txtTime2.setText("test2");
    			TextView txtTime3 = (TextView) findViewById(R.id.textView5);
    			txtTime3.setText("test3");
    			TextView txtTime4 = (TextView) findViewById(R.id.textView6);
    			txtTime4.setText("test4");
    		}

    		else{
    			TextView txtTime1 = (TextView) findViewById(R.id.textView3);
    			txtTime1.setText("");
    			TextView txtTime2 = (TextView) findViewById(R.id.textView4);
    			txtTime2.setText("");
    			TextView txtTime3 = (TextView) findViewById(R.id.textView5);
    			txtTime3.setText("Not found");
    			TextView txtTime4 = (TextView) findViewById(R.id.textView6);
    			txtTime4.setText("");
    		}
		}
    }

    //データベースにデータがあるか判定する関数(多分データベースの方で検索する)
    public boolean CheckData(String txtSearch){
    	if(txtSearch.equals("test")){
    		return true;
    	}
    	else if(txtSearch.equals("go")){
    		Intent i = new Intent(this, DetailsActivity.class);
    		startActivity(i);
    		return true;
    	}else{return false;}

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
