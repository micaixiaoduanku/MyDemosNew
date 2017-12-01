package demo.huangli.mydemosnew;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by huangli on 16/9/7.
 */
public class MyALiveApp extends Application{

    public static long logtime;

    @Override
    public void onCreate() {
//        strictMode();
        super.onCreate();
        logtime = System.currentTimeMillis();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private boolean OPEN_STRICTMODE = true;

    private void strictMode(){
        if (OPEN_STRICTMODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }
    }
}
