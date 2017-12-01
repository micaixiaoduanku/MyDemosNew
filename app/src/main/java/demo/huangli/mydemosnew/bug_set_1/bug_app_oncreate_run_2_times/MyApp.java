package demo.huangli.mydemosnew.bug_set_1.bug_app_oncreate_run_2_times;

import android.app.Application;
import android.util.Log;

import demo.huangli.mydemosnew.utils.PackageUtils;

/**
 * Created by huangli on 16/9/6.
 * 当运行多个进程的时候Application的oncreate函数会运行2次,如果非主进程不需要主进程资源的情况下,这会导致应用初始化资源多次,避免方案是
 * 通过运行的进程名和包名做比较进行过滤
 */
public class MyApp extends Application{

    public final static String TAG = "MyApp";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"MyApp onCreate调用 , 进程名字 "+ PackageUtils.getProcessNameByPID(this,android.os.Process.myPid()));
    }
}
