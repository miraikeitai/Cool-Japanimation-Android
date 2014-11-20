
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

public class TourCreatingActivity extends ActionBarActivity implements OnClickListener{

	String data1, data2, data3, data4, data5, data6;

	public static CheckFinish mflag = new CheckFinish();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourcreate_creating);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        View button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        View button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    /*ボタンを押した時の処理*/
    public void onClick(View v){
    	int id = v.getId();
		if (id == R.id.button1) {
			this.finish();//CreatingActivityの終了
		} else if (id == R.id.button2) {
			readEditText();
			Intent intent = new Intent(this, TourCreateConfirmationActivity.class);
			/*確認画面にテキストボックスのデータを送る*/
    		intent.putExtra("data1",data1);
			intent.putExtra("data2",data2);
			intent.putExtra("data3",data3);
			intent.putExtra("data4",data4);
			intent.putExtra("data5",data5);
			intent.putExtra("data6",data6);
			startActivity(intent);
		}
    }

    /*終了条件*/

    @Override
    public void onRestart(){
        super.onRestart();
        if(mflag.getFlagState()){
            this.finish();
        }
    }

    /*テキストボックスの文字を読み込む*/
    public void readEditText(){

    	EditText editText1 = (EditText) findViewById(R.id.editText1);
        data1 = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        data2 = editText2.getText().toString();

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        data3 = editText3.getText().toString();

        EditText editText4 = (EditText) findViewById(R.id.editText4);
        data4 = editText4.getText().toString();

        EditText editText5 = (EditText) findViewById(R.id.editText5);
        data5 = editText5.getText().toString();

        EditText editText6 = (EditText) findViewById(R.id.editText6);
        data6 = editText6.getText().toString();

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
