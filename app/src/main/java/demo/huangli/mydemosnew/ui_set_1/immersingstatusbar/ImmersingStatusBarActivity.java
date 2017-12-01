package demo.huangli.mydemosnew.ui_set_1.immersingstatusbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/8/22.
 */

public class ImmersingStatusBarActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersing_status_bar);
        findViewById(R.id.btn_way_1).setOnClickListener(this);
        findViewById(R.id.btn_way_2).setOnClickListener(this);
        findViewById(R.id.btn_way_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_way_1:
                Intent i = new Intent(this,FirstActivity.class);
                startActivity(i);
                break;
            case R.id.btn_way_2:
                break;
            case R.id.btn_way_3:
                break;
        }
    }
}
