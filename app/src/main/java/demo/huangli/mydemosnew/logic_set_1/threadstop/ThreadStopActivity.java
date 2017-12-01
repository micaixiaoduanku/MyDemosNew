package demo.huangli.mydemosnew.logic_set_1.threadstop;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/9/14.
 */

public class ThreadStopActivity extends Activity implements View.OnClickListener{

    Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_stop);
        findViewById(R.id.btn_start_thread).setOnClickListener(this);
        findViewById(R.id.btn_stop_thread).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_thread:
                Log.i("tag","启动线程");
                startThread();
                break;
            case R.id.btn_stop_thread:
                stopThread();
                break;
        }
    }

    private void startThread(){
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    if (Thread.interrupted()) {
                        // We've been interrupted: no more crunching.
                        return;
                    }
                    Log.i("tag","线程运行中....");
                }
            }
        };
        thread.start();
    }

    private void stopThread(){
        if (thread != null){
            thread.interrupt();
        }
    }
}
