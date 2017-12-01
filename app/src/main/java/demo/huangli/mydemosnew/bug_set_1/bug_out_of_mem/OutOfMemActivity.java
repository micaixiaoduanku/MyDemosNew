package demo.huangli.mydemosnew.bug_set_1.bug_out_of_mem;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/1/4.
 */

public class OutOfMemActivity extends Activity implements View.OnClickListener{

    public static final String ACTION_INTENT_FILTER = "ACTION_INTENT_FILTER";

    private Button btn;

    private MyBroadcastReceiver myBroadcastReceiver;

    private static class MyBroadcastReceiver extends BroadcastReceiver{

        private WeakReference<OutOfMemActivity> outOfMemActivityWeakReference;

        public MyBroadcastReceiver(WeakReference<OutOfMemActivity> outOfMemActivityWeakReference) {
            this.outOfMemActivityWeakReference = outOfMemActivityWeakReference;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        OutOfMemActivity outOfMemActivity = outOfMemActivityWeakReference.get();
                        Log.i("tag","running ... "+outOfMemActivity);
                    }
                }
            }.start();
        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i("tag","running ... "+OutOfMemActivity.this);
                    }
                }
            }.start();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_of_mem);
        WeakReference<OutOfMemActivity> weakReference = new WeakReference<>(this);
        myBroadcastReceiver = new MyBroadcastReceiver(weakReference);
        btn = (Button)findViewById(R.id.btn_send);
        btn.setOnClickListener(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_INTENT_FILTER);
        registerReceiver(broadcastReceiver,intentFilter);
//        registerReceiver(myBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
//        unregisterReceiver(myBroadcastReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                Intent intent = new Intent();
                intent.setAction(ACTION_INTENT_FILTER);
                sendBroadcast(intent);
                break;
        }
    }
}
