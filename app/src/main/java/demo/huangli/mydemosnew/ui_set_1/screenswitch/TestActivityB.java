package demo.huangli.mydemosnew.ui_set_1.screenswitch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import demo.huangli.mydemosnew.MyALiveApp;

/**
 * Created by huangli on 16/11/5.
 */

public class TestActivityB extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("timetest","MyApp到TestActivityB页面onCreate() "+(System.currentTimeMillis()- MyALiveApp.logtime));
        Intent intent = new Intent(TestActivityB.this, TestActivityC.class);
        startActivity(intent);
        finish();
    }
}
