/**
 *
 */
package com.example.cj_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author b1012234
 *
 */
public class MakeProfileActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_makeprofile);
        setTitle("プロフィール作成画面");

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("jp.example.cj_app", "jp.example.cj_app.TopPage");
                startActivity(intent);
                finish();
            }
        });
    }

}
