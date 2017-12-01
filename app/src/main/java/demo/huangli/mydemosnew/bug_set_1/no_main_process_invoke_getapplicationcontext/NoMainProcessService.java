package demo.huangli.mydemosnew.bug_set_1.no_main_process_invoke_getapplicationcontext;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by huangli on 16/9/23.
 */

public class NoMainProcessService extends Service{

    private Handler handler;

    public static String TAG = "NoMainProcessService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("pid","pid "+android.os.Process.myPid());
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                handler.sendEmptyMessageDelayed(0,500);
                Log.i(TAG,"application context "+getApplicationContext());
            }
        };
        handler.sendEmptyMessageDelayed(0,500);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
