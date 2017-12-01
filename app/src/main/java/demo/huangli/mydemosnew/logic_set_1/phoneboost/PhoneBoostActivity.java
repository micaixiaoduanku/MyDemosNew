package demo.huangli.mydemosnew.logic_set_1.phoneboost;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/2/3.
 */

public class PhoneBoostActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_boost);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                BoostManager.clearMemoryWay1(this);
                break;
            case R.id.btn_2:
                BoostManager.clearMemoryWay2(this);
                break;
            case R.id.btn_3:
                try {
                    BoostManager.clearMemoryWay3(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
