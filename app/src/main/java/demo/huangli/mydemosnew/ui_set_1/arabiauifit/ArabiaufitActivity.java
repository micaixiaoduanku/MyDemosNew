package demo.huangli.mydemosnew.ui_set_1.arabiauifit;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/11/10.
 */

public class ArabiaufitActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabiaufit);
        findViewById(R.id.btn_get).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:
                getRunningApps();
                break;
        }
    }

    private void getRunningApps(){
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am.getRunningAppProcesses();

        for (int i = 0; i < runningAppProcessInfo.size(); i++) {
            Log.i("tag",runningAppProcessInfo.get(i).processName);
        }
    }
}
